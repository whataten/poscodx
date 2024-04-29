package chapter04.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        // Queue<String> q = new LinkedList<>();
        Queue<String> q = new LinkedList<>();
        q.offer("마이콜");
        q.offer("둘리");
        q.offer("또치");

        while(!q.isEmpty()) {
            var s = q.poll();
            System.out.println(s);
        }

        System.out.println(q.poll());

        q.offer("마이콜");
        q.offer("둘리");
        q.offer("또치");

        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.poll());

    }
}
