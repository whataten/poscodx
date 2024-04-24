package prob05;

import java.util.Random;
import java.util.Scanner;

import java.lang.Math;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			// 정답 랜덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt(100) + 1;

			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			System.out.println("1-100");

			int trial_num = 0;
			int report_value = 0;
			int upper_bound = 100;
			int lower_bound = 1;

			while (true) {
				trial_num++;
				System.out.print(trial_num + ">>");

				report_value = scanner.nextInt();

				// 답보다 클 때
				if (report_value > correctNumber) {
					System.out.println("더 낮게");
					upper_bound = Math.min(report_value, upper_bound);
				}

				// 답보다 작을 때
				else if (report_value < correctNumber) {
					System.out.println("더 높게");
					lower_bound = Math.max(report_value, lower_bound);
				}

				// 정답일 때
				else {
					System.out.println("맞았습니다.");
					break;
				}

				System.out.println(Integer.toString(lower_bound) + "-" + Integer.toString(upper_bound));
			}

			// 새 게임 여부 확인하기
			System.out.print("다시 하겠습니까(y/n)>>");
			String answer = scanner.next();
			if ("y".equals(answer) == false) {
				break;
			}
		}
		scanner.close();
	}
}