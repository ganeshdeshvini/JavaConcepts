package enumexample;

public class EnumWithKeyValueExample {
    public static void main(String[] args) {
        int enumLength = ColorAnsiEnum.values().length;

        for (int i = 0; i <= enumLength; i++) {
            ColorAnsiEnum colorAnsiEnum = ColorAnsiEnum.getById(i);
            System.out.println(colorAnsiEnum.getColor() + colorAnsiEnum.name());
        }
    }
}
