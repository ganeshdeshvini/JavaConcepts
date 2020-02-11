package basics;

public class ClassAndObject {
	int i;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassAndObject obj1= new ClassAndObject();
		obj1.i = 6;
		ClassAndObject obj2 = obj1;
		
		System.out.println("obj1.i= " + obj1.i + ", obj2.i=" + obj2.i);
		obj1.i = 7;
		System.out.println("obj1.i= " + obj1.i + ", obj2.i=" + obj2.i);
		System.out.println("obj1 hascode " + obj1.hashCode() + ", obj2 hascode " + obj2.hashCode());
		obj2 = null;
		System.out.println("obj1.i= " + obj1.i);
		obj2 = new ClassAndObject();
		obj2.i = 10;
		System.out.println("obj1.i= " + obj1.i + ", obj2.i=" + obj2.i);
	}

}
