package OOP_A3;

/**
 * ColorStyle.java
 * The color codes for foregrounds and background
 * This class was created to focus on the color coding for use with console
 * output
 * 
 * Author: Eddie
 * Date: 2025-Oct-24
 */

public class ColorStyle {

    public static final String RESET_FORMATTING = "\033[0m";
    public static final String BLUE_BG_WHITE_FG = "\033[44;37m";

    // ANSI escape codes, for rbg - 38 is foreground, 48 is background
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[38;2;0;48;131m";
    public static final String DARK_BLUE = "\u001B[38;2;0;48;131m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Bright foreground colors
    public static final String BRIGHT_BLACK = "\u001B[90m";
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_BLUE = "\u001B[94m";
    public static final String TORQUISE_BLUE = "\u001B[38;2;26;132;184m";
    public static final String BRIGHT_MAGENTA = "\u001B[95m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static final String BRIGHT_WHITE = "\u001B[97m";

    // Background colors
    public static final String BLACK_BG = "\u001B[40m";
    public static final String RED_BG = "\u001B[41m";
    public static final String GREEN_BG = "\u001B[42m";
    public static final String BLUE_BG = "\u001B[48;2;0;48;131m";
    public static final String PURPLE_BG = "\u001B[45m";
    public static final String CYAN_BG = "\u001B[46m";
    public static final String WHITE_BG = "\u001B[47m";
    public static final String TORQUISE_BLUE_BG = "\u001B[48;2;26;132;184m";

    // Bright background colors
    public static final String BRIGHT_RED_BG = "\u001B[101m";
    public static final String BRIGHT_GREEN_BG = "\u001B[102m";
    public static final String BRIGHT_BLUE_BG = "\u001B[48;2;0;152;241m";
    public static final String BRIGHT_MAGENTA_BG = "\u001B[105m";
    public static final String BRIGHT_CYAN_BG = "\u001B[106m";
    public static final String BRIGHT_WHITE_BG = "\u001B[107m";

    // Yellows BG
    public static final String YELLOW_BG = "\u001B[43m";
    public static final String SUBTLE_YELLOW_BG = "\u001B[43m\u001B[2m";
    public static final String LIGHT_YELLOW_BG = "\u001B[103m";
    public static final String BRIGHT_YELLOW_BG = "\u001B[103m";
    public static final String CREAM_BG = "\u001B[100m"; // Bright black = light gray

    // Light cream color - RGB: 255, 253, 208
    public static final String CREAM_BG_RGB = "\u001B[48;2;255;255;220m";

    // Warmer cream color - RGB: 255, 253, 190
    public static final String WARM_CREAM_BG = "\u001B[48;2;255;253;190m";

    // Yellowish cream - RGB: 255, 248, 168
    public static final String YELLOWISH_CREAM_BG = "\u001B[48;2;255;248;168m";
}
