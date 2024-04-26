package exception;

public class ExceptionTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 10 - a;


        System.out.println("some code");
        
        try {
            System.out.println("some code1");
            System.out.println("some code2");
            int result = (1 + 2 + 3) / b;
            System.out.println("some code3");
            System.out.println("some code4");
        } catch (ArithmeticException e) {
            // 로깅
            System.out.println("error:" + e);

            // 사과
            System.out.println("sorry.");

            // 종료
            System.exit(1);

        } finally {
            // 자원 정리
            
        }
    }
}
