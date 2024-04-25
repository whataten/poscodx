package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for (int i = 0; i < COUNT_GOODS; i++) {
			try {
				var products = scanner.nextLine().split(" ");

				var temp = new Goods(products[0], products[1], products[2]);

				goods[i] = temp;

			} catch (Exception e) {
				scanner.close();
				return;
			}
		}
		// 상품 출력
		for (var product : goods) {
			System.out.println(product.getName()+"(가격:" + product.getPrice() + "원)이 " + product.getQuantity() + "개 입고되었습니다.");
		}
		
		// 자원정리
		scanner.close();
	}
}
