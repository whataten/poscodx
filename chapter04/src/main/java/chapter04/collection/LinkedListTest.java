package chapter04.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        list.add("둘리");
        list.add("마이콜");
        list.add("또치");

        // 순회 1
        for (int i = 0; i < list.size(); i++) {
            var s = list.get(i);
            System.out.println(s);
        }

        // 삭제
        list.remove(2);

        // 순회 2
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

        // 순회 3
        for (var i : list) {
            System.out.println(i);
        }
    }
}
