package helper;

public interface ThreadColors {
    String ANSI_RESET = "\u001B[0m";
    String ANSI_BLACK = "\u001b[30m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_BRIGHT_BLUE = "\u001b[34;1m";
    String ANSI_PURPLE = "\u001B[35m";
    String ANSI_MAGENTA = "\u001b[35m";
    String ANSI_CYAN = "\u001b[36m";
    String ANSI_WHITE = "\u001b[37m";
    String[] colors = {
            ANSI_RED, ANSI_YELLOW, ANSI_GREEN, ANSI_BLUE, ANSI_PURPLE,
            ANSI_MAGENTA, ANSI_CYAN, ANSI_WHITE, ANSI_BRIGHT_BLUE, ANSI_BLACK
    };
}