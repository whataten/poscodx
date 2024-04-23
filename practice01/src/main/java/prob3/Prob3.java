package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

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

		int sum = 0;

		// addition
		if (num % 2 == 0) {
			for (int i = 0; i <= num; i += 2) {
				sum += i;
			}
		} else {
			for (int i = 1; i <= num; i += 2) {
				sum += i;
			}
		}

		System.out.println("result : " + sum);
	}
}
