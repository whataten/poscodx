package chapter04.collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>();

        v.addElement("둘리");
        v.addElement("마이콜");
        v.addElement("마이콜");

        // 순회 1
        for (int i = 0; i < v.size(); i++) {
            var s = v.elementAt(i);
            System.out.println(s);
        }

        // 삭제
        v.removeElementAt(2);

        // 순회 2
        Enumeration<String> e = v.elements();
        while(e.hasMoreElements()) {
            String s = e.nextElement();
            System.out.println(s);
        }
    }
}
