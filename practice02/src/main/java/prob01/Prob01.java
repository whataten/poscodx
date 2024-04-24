package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		System.out.print("input number : ");

		int num;

		// set keyword
		try {
			num = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("enter number");
			return;
		} finally {
			scanner.close();
		}

		var sb = new StringBuilder();
		int count = 0;

		// make string
		for (int i = 0; i < MONEYS.length; i++) {
			count = num / MONEYS[i];
			num %= MONEYS[i];
			sb.append(Integer.toString(MONEYS[i])).append("won : ").append(Integer.toString(count)).append(".\n");
		}

		System.out.println(sb.toString());
	}
}