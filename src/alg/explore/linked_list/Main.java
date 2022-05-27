package alg.explore.linked_list;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(1));              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList);


    }
}

class MyLinkedList {
    private class Node {
        private int val;
        private Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(Node next) {
            this.next = next;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    private Node first;

    public MyLinkedList() {
        first = new Node();
    }

    public int get(int index) {
        Node newFirst = first;
        int i = 0;
        while (newFirst != null) {
            if (i == index + 1) return newFirst.val;
            newFirst = newFirst.next;
            i++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        if (first.next == null) {
            first.next = new Node(val);
            return;
        }
        Node node = new Node(val, first.next);
        first.next = node;
    }

    public void addAtTail(int val) {
        if (first.next == null) {
            first.next = new Node(val);
            return;
        }

        Node newFirst = first;
        Node previous = newFirst;
        while (newFirst != null) {
            previous = newFirst;
            newFirst = newFirst.next;
        }
        previous.next = new Node(val);
    }

    public void addAtIndex(int index, int val) {
        if(index==0){
            first.next = new Node(val,first.next);
        }
        Node newFirst = first;
        Node previous = newFirst;
        int i = 0;
        while (newFirst != null) {
            if (i == index + 1) {
                previous.next = new Node(val, newFirst);
                return;
            }
            previous = newFirst;
            newFirst = newFirst.next;
            i++;
        }
    }

    public void deleteAtIndex(int index) {
        if (first.next == null) return;
        Node newFirst = first;
        Node previous = newFirst;
        int i = 0;
        while (newFirst != null) {
            if (i == index + 1) {
                previous.next = newFirst.next;
                return;
            }
            previous = newFirst;
            newFirst = newFirst.next;
            i++;
        }
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "first=" + first +
                '}';
    }
}
