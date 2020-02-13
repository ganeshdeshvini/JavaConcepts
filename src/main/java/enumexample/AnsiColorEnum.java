package enumexample;

import java.util.Arrays;
import java.util.HashMap;

public enum AnsiColorEnum {
    ANSI_RED(0, "\u001B[31m"),
    ANSI_GREEN(1, "\u001B[32m"),
    ANSI_BLUE(2, "\u001B[34m"),
    ANSI_YELLOW(3, "\u001B[33m"),
    ANSI_PURPLE(4, "\u001B[35m"),
    ANSI_CYAN(5, "\u001b[36m"),
    ANSI_BRIGHT_BLUE(6, "\u001b[34;1m"),
    ANSI_WHITE(7, "\u001b[37m"),
    ANSI_BLACK(8, "\u001b[30m"),
    ANSI_RESET(9, "\u001B[0m");

    private int id;
    private String color;

    AnsiColorEnum(int id, String color) {
        this.id = id;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getId() {
        return id;
    }

    private static HashMap<Integer, AnsiColorEnum> mapIdColor = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(colorAnsiEnum -> mapIdColor.put(colorAnsiEnum.getId(), colorAnsiEnum));
    }

    public static AnsiColorEnum getAnsiColorEnumById(int id) {
        return mapIdColor.getOrDefault(id, ANSI_RESET);
    }

    public static String getColorById(int id) {
        return getAnsiColorEnumById(id).getColor();
    }
}