package behavioral.templatemethod;

public class Client {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.add();
		calc.sub();
		
		AbstractCalculate ac = new MultiplyCalculate();
		ac.templateMethod();
		
		ac = new DivideCalculate();
		ac.templateMethod();
		

	}

}
