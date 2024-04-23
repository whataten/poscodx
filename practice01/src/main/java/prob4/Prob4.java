package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("input : ");

		String text;

		// set keyword
		try {
			text = scanner.nextLine();
		} catch (Exception e) {
			System.out.println("wrong input");
			return;
		} finally {
			scanner.close();
		}

		var chars = text.split("");
		var sb = new StringBuilder();

		// make string
		for (int len = 0; len < chars.length; len++) {
			for (int i = 0; i <= len; i++) {
				sb.append(chars[i]);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
