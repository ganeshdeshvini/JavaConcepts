package basics;

public class BitwiseOperator {
	public static void main(String args[]) {
		int i;
		int num = 0xFFFFFFE;
		System.out.println(num);
		for (i = 0; i < 4; i++) {
			num = num << 1;
			System.out.println(num);
		}
		
		System.out.println(2147483632*2);
	}
}
