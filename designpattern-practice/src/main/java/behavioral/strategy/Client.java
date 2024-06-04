package behavioral.strategy;

public class Client {

	public static void main(String[] args) {
		var cc = new CalculateContext();
		
		cc.execute(new CalculateStrategy() {
			@Override
			public int calculate(int val1, int val2) {
				return val1 + val2;
			}
			
		});
		
		cc.execute((val1, val2) -> val1 + val2);

	}

}
