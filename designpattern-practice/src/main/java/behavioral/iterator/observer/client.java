package behavioral.iterator.observer;

import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        Subject<Integer> subject = new Subject<>();

        subject.registerObserver(new Observer<Integer>() {
            @Override
            public void update(Integer val) {
                System.out.println("Observer01 : " + val);
            }
        });

        subject.registerObserver(val -> System.out.println("Observer02 : " + val));

        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.print(">> ");
                int val = scanner.nextInt();
                subject.changeSubject(val);
            }

        } catch (Exception e) {

        }

    }
}
