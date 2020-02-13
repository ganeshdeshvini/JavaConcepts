package enumexample;

public class EnumWithKeyValueExample {
    public static void main(String[] args) {
        int enumLength = AnsiColorEnum.values().length;

        for (int i = 0; i <= enumLength; i++) {
            AnsiColorEnum ansiColorEnum = AnsiColorEnum.getAnsiColorEnumById(i);
            System.out.println(ansiColorEnum.getColor() + ansiColorEnum.name());
        }
    }
}
