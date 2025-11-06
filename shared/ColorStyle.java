package shared;

/**
 * ColorStyle.java
 * The ColorStyle class provides ANSI escape codes for console text and background coloring.
 * Contains essential color constants for creating console interfaces.
 * Comments were AI assisted using Perplexity. 
 * 
 * @author Eddie C.
 * @version 1.1
 * @since 2025-10-24
 */
public class ColorStyle {

    // Reset and formatting codes
    /** Resets all text formatting and colors to terminal defaults */
    public static final String RESET_FORMATTING = "\033[0m";
    
    /** Predefined combination of blue background with white foreground */
    public static final String BLUE_BG_WHITE_FG = "\033[44;37m";

    // Standard foreground colors
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
    
    /** Standard white foreground color */
    public static final String WHITE = "\u001B[37m";

    // Bright foreground colors
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
    
    /** Standard white background color */
    public static final String WHITE_BG = "\u001B[47m";
    
    /** Custom turquoise blue background color using RGB values (26, 132, 184) */
    public static final String TURQUOISE_BLUE_BG = "\u001B[48;2;26;132;184m";

    // Bright background colors
    /** Bright red background color */
    public static final String BRIGHT_RED_BG = "\u001B[101m";
    
    /** Bright green background color */
    public static final String BRIGHT_GREEN_BG = "\u001B[102m";
    
    /** Bright white background color */
    public static final String BRIGHT_WHITE_BG = "\u001B[107m";
}