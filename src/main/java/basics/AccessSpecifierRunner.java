package basics;

public class AccessSpecifierRunner {
    public static void main(String args[]) {
        AccessSpecifier ob = new AccessSpecifier();
        // These are OK, a and b may be accessed directly
        ob.a = 10;
        ob.b = 20;
        // This is not OK and will cause an error
        // ob.c = 100; // Error!
        // You must access c through its methods
        ob.setC(100); // OK
        System.out.println("a, b, and c: " + ob.a + " " + ob.b + " " + ob.getC());
    }

    /* This program demonstrates the difference between
public and private.
*/
    static class AccessSpecifier {
        int a; // default access
        public int b; // public access
        private int c; // private access

        // methods to access
        void setC(int i) { // set c's value
            c = i;
        }

        int getC() { // get c's value
            return c;
        }
    }
}