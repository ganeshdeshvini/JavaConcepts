package basics;

class OuterClass {
	public static void main(String[] args) {
		int a = 123;
		int num = a;
		int sum = 0;
		while(num > 0) {
			sum = sum *10;
			sum = sum + num %10;
			num = num /10;
		}
	}

	// inner class
	class InnerClass {
	}
}