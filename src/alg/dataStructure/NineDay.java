package alg.dataStructure;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class NineDay {
    public static void main(String[] args) {
        MyQueueLC myQueue = new MyQueueLC();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.pop();
        myQueue.push(5);
        myQueue.pop();
        System.out.println(myQueue);
        myQueue.pop();
        myQueue.pop();

        myQueue.pop();

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            try {
                if (isOpen(s.charAt(i))) {
                    stack.add(s.charAt(i));
                } else if (!canClose(stack.pop(), s.charAt(i))) {
                    return false;
                }
            } catch (EmptyStackException e) {
                return false;
            }

        }
        return stack.isEmpty();
    }

    private boolean isOpen(char charAt) {
        return charAt == '(' || charAt == '[' || charAt == '{';
    }

    private boolean canClose(char openChar, char closeChar) {
        return (openChar == '(' && closeChar == ')') || (openChar == '[' && closeChar == ']') || (openChar == '{' && closeChar == '}');
    }
}

class MyQueue {

    private List<Integer> list;
    private int size;

    public MyQueue() {
        this.list = new ArrayList<>();
    }

    public void push(int x) {
        this.size++;
        list.add(x);
    }

    public int pop() {
        int val = list.get(0);
        list.remove(0);
        this.size--;
        return val;
    }

    public int peek() {
        return list.get(0);
    }

    public boolean empty() {
        return size == 0;
    }
}

class MyQueueLC {
    private final Stack<Integer> s1;
    private final Stack<Integer> s2;
    private int front;

    public MyQueueLC() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.empty()) {
            front = x;
        }
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }


    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;

    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    @Override
    public String toString() {
        return "MyQueueLC{" +
                "s1=" + s1 +
                ", s2=" + s2 +
                ", front=" + front +
                '}';
    }
}