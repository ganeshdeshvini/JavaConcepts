package stringprograms;

public class PalindromeString {

	public static boolean checkPalindrome(String s) {

		StringBuilder sb = new StringBuilder(s);
		int len = sb.length();
		for (int forwPtr = 0, backPtr = len - 1; forwPtr < len / 2; forwPtr++, backPtr--) {
			if (sb.charAt(forwPtr) != sb.charAt(backPtr)) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkPalindromeWithSpace(String s) {
		int forwPtr = 0;
		int len = s.length();
		int backPtr = len - 1;

		while (forwPtr <= backPtr) {
			while (forwPtr < len && !Character.isLetter(s.charAt(forwPtr))) {
				forwPtr++;
			}
			
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "abba";
		System.out.println(checkPalindrome(s) ? "Palindrome" : "Not Palindrome");
	}

}
