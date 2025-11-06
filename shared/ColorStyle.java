package shared;

/**
 * ColorStyle.java
 * The ColorStyle class provides ANSI escape codes for console text and background coloring.
 * Contains comprehensive color constants for creating professional console interfaces
 * with both standard and custom RGB color support. Comments were AI assisted using Perplexity. 
 
 * 
 * @author Eddie C.
 * @version 1.0
 * @since 2025-10-24
 */
public class ColorStyle {

    // Reset and combined formatting codes
    /** Resets all text formatting and colors to terminal defaults */
    public static final String RESET_FORMATTING = "\033[0m";
    
    /** Predefined combination of blue background with white foreground */
    public static final String BLUE_BG_WHITE_FG = "\033[44;37m";

    // ANSI escape codes - Standard foreground colors
    /** Resets all text formatting and colors */
    public static final String RESET = "\u001B[0m";
    
    /** Standard black foreground color */
    public static final String BLACK = "\u001B[30m";
    
    /** Standard red foreground color */
    public static final String RED = "\u001B[31m";
    
    /** Standard green foreground color */
    public static final String GREEN = "\u001B[32m";
    
    /** Standard yellow foreground color */
    public static final String YELLOW = "\u001B[33m";
    
    /** Custom blue foreground color using RGB values (0, 48, 131) */
    public static final String BLUE = "\u001B[38;2;0;48;131m";
    
    /** Custom dark blue foreground color using RGB values (0, 48, 131) */
    public static final String DARK_BLUE = "\u001B[38;2;0;48;132m";
    
    /** Standard purple foreground color */
    public static final String PURPLE = "\u001B[35m";
    
    /** Standard cyan foreground color */
    public static final String CYAN = "\u001B[36m";
    
    /** Standard white foreground color */
    public static final String WHITE = "\u001B[37m";

    // Bright foreground colors
    /** Bright black foreground color (dark gray) */
    public static final String BRIGHT_BLACK = "\u001B[90m";
    
    /** Bright red foreground color */
    public static final String BRIGHT_RED = "\u001B[91m";
    
    /** Bright green foreground color */
    public static final String BRIGHT_GREEN = "\u001B[92m";
    
    /** Bright yellow foreground color */
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    
    /** Bright blue foreground color */
    public static final String BRIGHT_BLUE = "\u001B[94m";
    
    /** Custom turquoise blue foreground color using RGB values (26, 132, 184) */
    public static final String TURQUOISE_BLUE = "\u001B[38;2;26;132;184m";
    
    /** Bright magenta foreground color */
    public static final String BRIGHT_MAGENTA = "\u001B[95m";
    
    /** Bright cyan foreground color */
    public static final String BRIGHT_CYAN = "\u001B[96m";
    
    /** Bright white foreground color */
    public static final String BRIGHT_WHITE = "\u001B[97m";

    // Standard background colors
    /** Standard black background color */
    public static final String BLACK_BG = "\u001B[40m";
    
    /** Standard red background color */
    public static final String RED_BG = "\u001B[41m";
    
    /** Standard green background color */
    public static final String GREEN_BG = "\u001B[42m";
    
    /** Custom blue background color using RGB values (0, 48, 131) */
    public static final String BLUE_BG = "\u001B[48;2;0;48;131m";
    
    /** Standard purple background color */
    public static final String PURPLE_BG = "\u001B[45m";
    
    /** Standard cyan background color */
    public static final String CYAN_BG = "\u001B[46m";
    
    /** Standard white background color */
    public static final String WHITE_BG = "\u001B[47m";
    
    /** Custom turquoise blue background color using RGB values (26, 132, 184) */
    public static final String TURQUOISE_BLUE_BG = "\u001B[48;2;26;132;184m";

    // Bright background colors
    /** Bright red background color */
    public static final String BRIGHT_RED_BG = "\u001B[101m";
    
    /** Bright green background color */
    public static final String BRIGHT_GREEN_BG = "\u001B[102m";
    
    /** Custom bright blue background color using RGB values (0, 152, 241) */
    public static final String BRIGHT_BLUE_BG = "\u001B[48;2;0;152;241m";
    
    /** Bright magenta background color */
    public static final String BRIGHT_MAGENTA_BG = "\u001B[105m";
    
    /** Bright cyan background color */
    public static final String BRIGHT_CYAN_BG = "\u001B[106m";
    
    /** Bright white background color */
    public static final String BRIGHT_WHITE_BG = "\u001B[107m";

    // Yellow background variations
    /** Standard yellow background color */
    public static final String YELLOW_BG = "\u001B[43m";
    
    /** Subtle yellow background with dim text effect */
    public static final String SUBTLE_YELLOW_BG = "\u001B[43m\u001B[2m";
    
    /** Light yellow background color */
    public static final String LIGHT_YELLOW_BG = "\u001B[103m";
    
    /** Bright yellow background color */
    public static final String BRIGHT_YELLOW_BG = "\u001B[104m";
    
    /** Cream background using bright black (light gray) */
    public static final String CREAM_BG = "\u001B[100m";

    // Custom RGB cream background colors
    /** Light cream background color using RGB values (255, 255, 220) */
    public static final String CREAM_BG_RGB = "\u001B[48;2;255;255;220m";
    
    /** Warm cream background color using RGB values (255, 253, 190) */
    public static final String WARM_CREAM_BG = "\u001B[48;2;255;253;190m";
    
    /** Yellowish cream background color using RGB values (255, 248, 168) */
    public static final String YELLOWISH_CREAM_BG = "\u001B[48;2;255;248;168m";
}