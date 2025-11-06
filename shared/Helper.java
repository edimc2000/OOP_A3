package shared;

import static java.lang.System.*;

/**
 * Helper.java
 * The Helper class provides utility methods for text formatting, screen
 * manipulation,
 * and visual presentation in the payroll management system. Includes number
 * formatting,
 * cursor control, color application, and section display utilities.
 * 
 * @author Eddie C.
 * @version 1.6
 * @since 2025-10-24
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

    public static String formatFourDecimals(double decimal) {
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

    /**
     * Moves the console cursor to specific positions for precise text placement.
     * Supports moving to the end of the current line or to previous lines with
     * specific column positioning.
     *
     * @param line     the target line: "current" for current line end, "last" for
     *                 previous line, "lastTwo" for two lines previous
     * @param position the column position to move to on the target line
     */
    public static void moveToLastCharPreviousLine(String line, int position) {
        // Move to end of current line
        if (line.equals("current")) {
            out.print("\033[999C"); // Move cursor right 999 columns (to end of line)
        }

        // Go to the previous line first, then to position:
        if (line.equals("last")) {
            out.print("\033[1A");
            out.print("\033[" + position + "C");
        }

        // Go to the prev 2 lines first, then to position:
        if (line.equals("lastTwo")) {
            out.print("\033[1A \033[1A");
            out.print("\033[" + position + "C");
        }
    }

    /**
     * Applies color highlighting to display content by splitting it into lines
     * and applying foreground and background colors to each line individually.
     * Automatically resets formatting after each line.
     *
     * @param display    the text content to be displayed with highlighting
     * @param foreground the foreground color code from ColorStyle class
     * @param background the background color code from ColorStyle class
     */
    public static void applyHighlighter(String display, String foreground, String background) {
        String[] lines = display.split("\n");
        String colorCode = foreground + background;

        for (String line : lines) {
            out.println(colorCode + line + ColorStyle.RESET_FORMATTING);
        }
    }

    /**
     * Clears the console screen using ANSI escape codes.
     * This method works on most Unix-based terminals and Windows Command Prompt
     * with ANSI support enabled.
     */
    public static void clearScreen() {
        out.print("\033[H\033[2J");
        out.flush();
    }

    /**
     * Generates formatted section borders for console display.
     * Creates opening, closing, or divider lines with consistent styling.
     *
     * @param direction the type of section border to create:
     *                  "open" - top border, "close" - bottom border,
     *                  "divider" - horizontal separator line
     * @return the formatted section border string
     */
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

    /**
     * Centers a title within a specified width and adds border characters.
     * Calculates optimal padding to achieve balanced centering for professional
     * display formatting.
     *
     * @param title       the text to be centered
     * @param totalWidth  the total width available for the title
     * @param borderLeft  the left border character(s)
     * @param borderRight the right border character(s)
     * @return the formatted and centered title string with borders
     */
    public static String printBalancedTitle(String title, int totalWidth, String borderLeft, String borderRight) {
        // Calculate the exact padding needed for center alignment
        int totalSpaces = totalWidth - title.length();
        int leftSpaces = totalSpaces / 2;
        int rightSpaces = totalSpaces - leftSpaces;

        String formatted = " ".repeat(leftSpaces) + title + " ".repeat(rightSpaces);
        return String.format(borderLeft + "%s" + borderRight, formatted);
    }
}
