package sonar;


public class ConstructorCallingOverrridableMethod {
    static class SeniorClass {
        public SeniorClass() {
            toString(); //may throw NullPointerException if overridden
        }

        public String toString() {
            return "IAmSeniorClass";
        }
    }

    static class JuniorClass extends SeniorClass {
        private String name;

        public JuniorClass() {
            super(); //Automatic call leads to NullPointerException
            name = "JuniorClass";
        }

        public String toString() {
            return name.toUpperCase();
        }
    }

    public static void main(String[] args) {
        SeniorClass bc = new SeniorClass();
        SeniorClass sc = new JuniorClass();
    }
}
