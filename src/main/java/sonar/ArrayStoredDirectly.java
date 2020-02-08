package sonar;

import java.util.Arrays;

public class ArrayStoredDirectly {

    private final boolean[] itemBoolean;

    public ArrayStoredDirectly(boolean[] flags) {
        this.itemBoolean = flags;
        //Uncomment to see Magic of without reference
//        this.itemBoolean = Arrays.copyOf(flags, flags.length);
        System.out.println("INSIDE:: Constructor");
        printBooleanArray();
    }

    static void testShallowCopy() {
        String[] str1 = {"1", "2", "3"};

        String[] str2 = Arrays.copyOf(str1, str1.length);

        //it will greet all true as it Arrays.copyOf just copies the
        //reference & not the values(== checks for reference) otherwise
        //it should have printed false
        for (int i = 0; i < str1.length; i++) {
            System.out.println(str1[i] == str2[i]);

        }
    }

    static void testDeepCopy() {
        String[] str1 = {"1", "2", "3"};
        String[] str3 = new String[str1.length];
        for (int i = 0; i < str1.length; i++) {
            str3[i] = new String(str1[i]);
        }
        for (int i = 0; i < str1.length; i++) {
            System.out.println(str1[i] == str3[i]);
            //uncomment for checking the equals method
//            System.out.println(str1[i].equals(str3[i]));
        }
    }

    void printBooleanArray(){
        for (boolean b : this.itemBoolean) {
            System.out.println(b);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        testShallowCopy();
        System.out.println("\n");
        testDeepCopy();
        boolean[] arrBoolean = {true, false};
        ArrayStoredDirectly arrayStoredDirectly = new ArrayStoredDirectly(arrBoolean);
        arrBoolean[1] = true;
        System.out.println("INSIDE:: MAIN");
        for (boolean b : arrBoolean) {
            System.out.println(b);
        }
        System.out.println("INSIDE:: printBooleanArray");
        arrayStoredDirectly.printBooleanArray();
    }
}
