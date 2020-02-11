package stringprograms;

public class StringReverse {

	static void normalReverse() {
		String s = "abcdefg";
		StringBuilder sb = new StringBuilder();
		long start = System.nanoTime();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		System.out.println("StringBuilderCustom: " + (System.nanoTime() - start));
		s = "abcdefg";
		StringBuilder sb1 = new StringBuilder(s);
		start = System.nanoTime();
		sb1.reverse();
		System.out.println("StringBuilderReverse: " + (System.nanoTime() - start));
	}

	static void inPlaceReverse() {
		String s = "abcdefg";
		StringBuilder sb = new StringBuilder(s);
		long start = System.nanoTime();
		int sbLength = sb.length();
		char startTemp;
		char endTemp;
		int endLen;
		for (int i = 0; i < sbLength / 2; i++) {
			endLen = sbLength - 1 - i;
			startTemp = sb.charAt(i);
			endTemp = sb.charAt(endLen);
			if (startTemp != endTemp) {
				sb.setCharAt(i, endTemp);
				sb.setCharAt(endLen, startTemp);
			}
		}
		System.out.println("InPlaceTime: " + (System.nanoTime() - start));
	}

	public static void main(String[] args) {
		normalReverse();
		inPlaceReverse();
	}
}
