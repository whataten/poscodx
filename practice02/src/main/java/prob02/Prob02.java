package prob02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];
		double sum = 0;
		
		/* 키보드에서 배열 크기만큼 입력 받아 배열에 저장하는 코드 */
		for (int i = 0; i < intArray.length; i++) {
			System.out.print("input number : ");
	
			int num;

			// set keyword
			try {
				num = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("enter number");
				return;
			}

			intArray[i] = num;
		}

		/* 배열에 저장된 정수 값 더하기 */
		for (int element : intArray) {
			sum += element;
		}

		/* 출력 */
		System.out.println("average : " + String.valueOf(sum/intArray.length));

		/* 자원정리 */
		scanner.close();
	}
}
