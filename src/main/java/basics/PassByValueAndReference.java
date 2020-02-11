package basics;

public class PassByValueAndReference {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("========PassByValue for Primitive========");
        PassByValueForPrimitive passByValueForPrimitive = new PassByValueForPrimitive();
        int a = 15, b = 20;
        System.out.println("a and b before call: " + a + " " + b);
        passByValueForPrimitive.test(a, b);
        System.out.println("a and b after call: " + a + " " + b);

        System.out.println("========PassByReference for Object========");
        PassByReferenceForObject passByReferenceForObject = new PassByReferenceForObject(15, 20);
        System.out.println("ob.a and ob.b before call: " + passByReferenceForObject.a + " " + passByReferenceForObject.b);
        passByReferenceForObject.test(passByReferenceForObject);
        System.out.println("ob.a and ob.b after call: " + passByReferenceForObject.a + " " + passByReferenceForObject.b);
    }

    //Primitive types are passed by value.
    static class PassByValueForPrimitive {
        void test(int i, int j) {
            j *= 2;
            i /= 2;
        }
    }

    // Objects are passed through their references.
    static class PassByReferenceForObject {
        int a, b;

        public PassByReferenceForObject(int i, int j) {
            // TODO Auto-generated constructor stub
            a = i;
            b = j;
        }

        void test(PassByReferenceForObject passByReferenceForObject) {
            passByReferenceForObject.a *= 2;
            passByReferenceForObject.b /= 2;
        }
    }
}
