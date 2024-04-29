package chapter04.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest01 {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();

        String s1 = new String("둘리");

        s.add("둘리");
        s.add("마이콜");
        s.add("도우너");
        // 안들어감 내용으로 판단함 -> 힙, 상수풀 상관x
        // 동일성 x , 동질성 o
        s.add(s1);

        System.out.println(s.size());
        System.out.println(s.contains(s1));

        for (var str : s) {
            System.out.println(str);
        }
    }
}
