package basics;

public class ConstructorManualCopy {
	double width;
	double height;
	double depth;

	ConstructorManualCopy(ConstructorManualCopy objToCopy) {
		// TODO Auto-generated constructor stub
		this.width = objToCopy.width;
		this.height = objToCopy.height;
		this.depth = objToCopy.depth;
	}

	public ConstructorManualCopy() {
		//
	}

	public static void main(String[] args) {
		ConstructorManualCopy obj1 = new ConstructorManualCopy();
		obj1.width = 1;
		obj1.height = 2;
		obj1.depth = 3;
		ConstructorManualCopy obj2 = new ConstructorManualCopy(obj1);
		System.out.println(obj1.hashCode() + " : " + obj2.hashCode());
		System.out.println(obj1.width + " : " + obj2.width);
	}
}
