package helper;

public enum ThreadColor {
    ANSI_RED("\u001B[31m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_BLUE("\u001B[34m"),
    ANSI_PURPLE("\u001B[35m"),
    ANSI_MAGENTA("\u001b[35m"),
    ANSI_CYAN("\u001b[36m"),
    ANSI_BRIGHT_BLUE("\u001b[34;1m"),
    ANSI_WHITE("\u001b[37m"),
    ANSI_RESET("\u001B[0m"),
    ANSI_BLACK("\u001b[30m");

    ThreadColor(String color) {
    }
}
