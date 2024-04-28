package prob1;

public class Sort {

	public static void main(String[] arg) {

		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int count = array.length;

		System.out.println("Before sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}

		for (int start = 0; start < array.length - 1; start++) {
			for (int i = 0; i < array.length - start - 1; i++) {
				if (array[i] < array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}

		// 결과 출력
		System.out.println("\nAfter Sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}
	}
}