package OOP_A3;

import static java.lang.System.*;

/**
 * Helper.java
 * The formatters and other helpers
 * 
 * Author: Eddie
 * Date: 2025-Oct-24
 */

public class Helper {

    /**
     * Formats a decimal number to two decimal places with grouping separators.
     * Returns a string representation of the number formatted according to the
     * default locale's number formatting rules.
     *
     * @param decimal the decimal number to be formatted
     * @return a formatted string representation of the number with two decimal
     *         places and grouping separators (commas for thousands)
     * 
     * 
     * @example
     *          // Returns "1,234.56"
     *          formatTwoDecimals(1234.56789);
     * 
     * @example
     *          // Returns "0.00"
     *          formatTwoDecimals(0.0);
     * 
     * @example
     *          // Returns "999,999.99"
     *          formatTwoDecimals(999999.9994);
     */
    public static String formatTwoDecimals(double decimal) {
        return String.format("%,.2f", decimal);
    }

    /**
     * Formats a decimal number to four decimal places with grouping separators.
     * Returns a string representation of the number formatted according to the
     * default locale's number formatting rules.
     *
     * @param decimal the decimal number to be formatted
     * @return a formatted string representation of the number with two decimal
     *         places and grouping separators (commas for thousands)
     * @example
     *          // Returns "1,234.5678"
     *          formatTwoDecimals(1234.56789);
     * 
     * @example
     *          // Returns "0.0000"
     *          formatTwoDecimals(0.0);
     * 
     * @example
     *          // Returns "999,999.9994"
     *          formatTwoDecimals(999999.9994);
     */

    public static String formatfourDecimals(double decimal) {
        return String.format("%,.4f", decimal);
    }

    /**
     * Formats a decimal number to zero decimal places with grouping separators.
     * Returns a string representation of the number formatted according to the
     * default locale's number formatting rules, including commas as thousands
     * separators.
     *
     * @param decimal the decimal number to be formatted
     * @return a formatted string representation of the number with grouping
     *         separators
     *         and no decimal places
     *
     * @example
     *          // Returns "1,235"
     *          formatCommas(1234.56789);
     *
     * @example
     *          // Returns "0"
     *          formatCommas(0.0);
     *
     * @example
     *          // Returns "1,000,000"
     *          formatCommas(999999.99);
     */
    public static String formatCommas(double decimal) {
        return String.format("%,.0f", decimal);
    }

    public static void moveToLastCharPreviousLine(String line, int position) {
        // Move to end of current line
        if (line.equals("current")) {
            out.print("\033[999C"); // Move cursor right 999 columns (to end of line)
        }

        // Go to the last line first, then to end:
        if (line.equals("last")) {
            // out.print("\033[1A \033[1A"); // Move up two lines
            out.print("\033[1A"); // Move up two lines
            out.print("\033[" + position + "C");

            // out.flush();
        }
    }

    public static void applyHighlighter(String display, String foreground, String background) {
        String[] lines = display.split("\n");
        String colorCode = foreground + background;

        for (String line : lines) {
            out.println(colorCode + line + ColorStyle.RESET_FORMATTING);
        }
    }

    // clear screen
    public static void clearScreen() {
        out.print("\033[H\033[2J");
        out.flush();
    }

    // formatting sections

    public static String section(String direction) {
        StringBuilder headerDesign = new StringBuilder("");

        if (direction.equals("open")) {
            headerDesign.append(String.format(" ┌%-64s┐ ", "*".repeat(64))
                    .replace("*", "─"));
            return headerDesign.toString();

        }
        if (direction.equals("close")) {
            headerDesign.append(String.format(" └%-64s┘ ", "*".repeat(64))
                    .replace("*", "─"));
            return headerDesign.toString();
        }

        if (direction.equals("divider")) {
            headerDesign.append(String.format("%-69s", "")
                    .replace(" ", "-").trim());
            return headerDesign.toString();
        }

        return headerDesign.toString();

    }

    // formatting
    public static String printBalancedTitle(String title, int totalWidth, String borderLeft, String borderRight) {
        // Calculate the exact padding needed for center alignment
        int totalSpaces = totalWidth - title.length();
        int leftSpaces = totalSpaces / 2;
        int rightSpaces = totalSpaces - leftSpaces;

        String formatted = " ".repeat(leftSpaces) + title + " ".repeat(rightSpaces);
        return String.format(borderLeft + "%s" + borderRight, formatted);
    }
}
