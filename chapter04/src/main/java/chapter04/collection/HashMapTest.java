package chapter04.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();

        m.put("one", 1); // auto boxing : int --> Integer
        m.put("two", 2);
        m.put("three", 3);

        int i = m.get("one"); // auto unboxing : Integer --> int
        int j = m.get(new String("one")); // 동질성

        System.out.println(i + ":" + j);
        m.put("three", 3333);
        System.out.println(m.get("three"));

        // 순회
        for (var key : m.keySet()) {
            var value = m.get(key);
            System.out.println(key + ":" + value);
        }
    }
}
