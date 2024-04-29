package behavioral.iterator;

public class Client {
    public static void main(String[] agrs) {
        Aggregate<String> fruits = new AggreGateImpl<>(new String[] {"mango", "banana", "Apple"});
        Iterator<String> it = fruits.createIterator();

        while(it.hasNext()) {
            String fruit = it.next();
            System.out.println(fruit);
        }
    }
}
