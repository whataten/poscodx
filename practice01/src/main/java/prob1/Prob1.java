package prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		
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
		
		// judge
		if (num % 3 == 0) {
			System.out.println("multiples of 3");
		} else {
			System.out.println("not multiples of 3");
		}
	}
}
