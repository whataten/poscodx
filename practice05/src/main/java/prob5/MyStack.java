package prob5;

import java.util.*;

public class MyStack {

    int limit;
    ArrayList<String> stack = new ArrayList<>();

    public MyStack(int limit) {
        this.limit = limit;
    }

    public void push(String data) {
        stack.add(data);
    }

    public String pop() throws MyStackException{
        if(isEmpty()) {
            throw new MyStackException("stack is empty");
        }
        
        int len = stack.size(); // Arraylist에저장된 유효한 자료의 개수

        return (stack.remove(len - 1)); // 맨 뒤에 있는 자료 반환
    }

    public boolean isEmpty() {
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}