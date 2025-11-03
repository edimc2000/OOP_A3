package OOP_A3;

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
}
