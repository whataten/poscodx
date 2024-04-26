package chapter04;

public class ObjectTest01 {
    public static void main(String[] args) {
        Point point = new Point(10, 20);

        Class klass = point.getClass();

        System.out.println(point.getClass()); // reflection
        System.out.println(point.hashCode());   // address 기반의 해싱
                                                // address x
                                                // reference x
        System.out.println(point.toString()); // getClass() + "@" + 
        System.out.println(point);
    }
}
