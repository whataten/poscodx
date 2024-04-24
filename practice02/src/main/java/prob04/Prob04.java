package prob04;

public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);

		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}

	public static char[] reverse(String str) {

		var chars = str.toCharArray();
		char[] result = new char[chars.length];

		for (int i = chars.length - 1; i >= 0; i--) {
			result[chars.length - i - 1] = chars[i];
		}

		return result;
	}

	public static void printCharArray(char[] array) {
		System.out.println(array);
	}
}