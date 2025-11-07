package test;

// Command to run the test manual from CLI - complie and run, it should be on the root folder
// javac -d test\out src\*.java shared\*.java test\*.java && java -cp test\out test.TestProgramPayrolManager
// or runtest.cmd


// SystemIOCapture.java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import src.PayrollManager;

public class TestProgramPayrolManager {

    public static String captureOutput(Runnable testCode) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        

        // Create a tee OutputStream that writes to both the baos (capture) and the original console
        OutputStream tee = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                baos.write(b);
                try {
                    // convert single byte to string using UTF-8 and print via originalOut to respect its encoding
                    byte[] single = new byte[] { (byte) b };
                    String s = new String(single, StandardCharsets.UTF_8);
                    originalOut.print(s);
                } catch (Exception ignored) {
                }
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                baos.write(b, off, len);
                try {
                    // convert bytes to a UTF-8 string then print via originalOut so console encoding is handled
                    String s = new String(b, off, len, StandardCharsets.UTF_8);
                    originalOut.print(s);
                } catch (Exception ignored) {
                }
            }

            @Override
            public void flush() throws IOException {
                baos.flush();
                try { originalOut.flush(); } catch (Exception ignored) {}
            }
        };

        PrintStream combined = null;
        try {
            combined = new PrintStream(tee, true, StandardCharsets.UTF_8.name());
            // Redirect System.out and System.err to the combined stream which tees to console and capture
            System.setOut(combined);
            System.setErr(combined);

            // Execute test
            testCode.run();

            // Ensure everything flushed
            combined.flush();
            return baos.toString(StandardCharsets.UTF_8.name());
        } catch (Exception e) {
            e.printStackTrace();
            return "Error during test execution: " + e.getMessage();
        } finally {
            // Restore original streams
            if (combined != null) combined.flush();
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }

    public static void provideInput(String input, Runnable testCode) {
        InputStream originalIn = System.in;
        PipedOutputStream pos = null;
        Thread typer = null;
        try {
            // Create a piped input stream that the program will read from
            PipedInputStream pis = new PipedInputStream();
            pos = new PipedOutputStream(pis);
            System.setIn(pis);

            final PipedOutputStream writerStream = pos;
            // Start a background thread that "types" the input char-by-char and echoes it to System.out
            typer = new Thread(() -> {
                try {
                    // small initial delay to let program print its first prompt(s) before we start typing
                    try { Thread.sleep(200); } catch (InterruptedException ignored) {}
                    String[] lines = input.split("\\r?\\n", -1);
                    for (int li = 0; li < lines.length; li++) {
                        String line = lines[li];
                        for (int i = 0; i < line.length(); i++) {
                            char ch = line.charAt(i);
                            byte[] b = String.valueOf(ch).getBytes(StandardCharsets.UTF_8);
                            writerStream.write(b);
                            writerStream.flush();
                            // Echo typed char to the current System.out (which may be captured)
                            System.out.print(ch);
                            System.out.flush();
                            try { Thread.sleep(20); } catch (InterruptedException ignored) {}
                        }
                        // Send CRLF to simulate Enter
                        writerStream.write('\r');
                        writerStream.write('\n');
                        writerStream.flush();
                        System.out.println(); // echo newline
                        try { Thread.sleep(80); } catch (InterruptedException ignored) {}
                    }
                } catch (IOException e) {
                    // ignore; test may finish early
                } finally {
                    try { writerStream.close(); } catch (IOException ignored) {}
                }
            }, "input-typer");
            typer.setDaemon(true);
            typer.start();

            // Run the test code which will read from System.in
            testCode.run();

            // Wait for typer to finish sending all input
            try { if (typer != null) typer.join(20); } catch (InterruptedException ignored) {}

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Restore original System.in
            try { if (pos != null) pos.close(); } catch (IOException ignored) {}
            System.setIn(originalIn);
        }
    }

    public static void testUserInteraction() {
        // Build the input lines using the platform line separator to avoid accidental escape sequences
        String[]  lines = new String[] { "1", "Loren Gullk", "866-978-125-1", "11", "2", "20", "41", "n" };
        String testInput = String.join(System.lineSeparator(), Arrays.asList(lines)) + System.lineSeparator();

        String output = captureOutput(() -> {
            provideInput(testInput, () -> {
                PayrollManager.main(new String[] {});
            });
        });

        // System.out.println("\n\n============================================== CAPTURED OUTPUT ==============================================\n");
        // System.out.println(output);
        // System.out.println("\n\n=============================================================================================================");
    }

    // Additional test methods
    public static void testMultipleScenarios() {
        // Test case 1: Normal input
        System.out.println("\n\n--- Test Case 1: Normal Input ---\n\n");
        testUserInteraction();
        System.out.println("");
    }

    public static void main(String[] args) {
        System.out.println("Starting automated tests...");
        testMultipleScenarios();
        System.out.println("\nTest execution completed!");
    }
}