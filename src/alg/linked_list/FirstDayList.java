package alg.linked_list;

import alg.domains.ListNode;

import java.util.*;

public class FirstDayList {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = new FirstDayList().sortList(node1);
//        System.out.println(node);
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addAtHead(1);
        list.addAtHead(2);
        list.addAtTail(3);
        list.addAtIndex(1,2);
        System.out.println(list);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode middle = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            middle = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        middle.next = null;

        ListNode reverseList = reverse(slow);
        mergeLists(head, reverseList);
    }

    private void mergeLists(ListNode first, ListNode second) {

        while (first != null) {
            ListNode f = first.next;
            ListNode s = second.next;
            first.next = second;

            if (f == null) break;

            second.next = f;
            first = f;
            second = s;
        }

    }

    private ListNode reverse(ListNode node) {
        ListNode previous = null;
        ListNode main = node;
        ListNode head = node;
        while (head != null) {
            main = new ListNode(head.val, previous);
            previous = main;
            head = head.next;
        }
        return main;
    }

    public ListNode swapPairs(ListNode head) {
        return swapNodes(head);
    }

    private ListNode swapNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nextNext = head.next.next;
        ListNode next = head.next;
        next.next = head;
        head.next = swapNodes(nextNext);
        return next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode first = node;
        int sum = 0;
        while (l1 != null || l2 != null) {
            int current = sum;
            if (l1 != null) {
                current += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                current += l2.val;
                l2 = l2.next;
            }
            sum = current > 9 ? 1 : 0;
            node.next = new ListNode(current % 10);
            node = node.next;
        }
        if (sum != 0) node.next = new ListNode(1);
        return first.next;
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null) return true;

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode();
        node.next = head;
        ListNode fast = node;
        ListNode slow = node;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return node.next;
    }

    public ListNode sortList(ListNode head) {
        System.out.println(head);
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        ListNode list2 = sortList(head);

        ListNode list1 = sortList(slow);
        return mergeMyLists(list1, list2);
    }

    private ListNode mergeMyLists(ListNode slow, ListNode fast) {
        ListNode result = new ListNode();
        ListNode first = result;
        while (slow != null && fast != null) {
            System.out.println(result);
            if (slow.val < fast.val) {
                result.next = slow;
                slow = slow.next;
            } else {
                result.next = fast;
                fast = fast.next;
            }
            result = result.next;
        }
        while (slow != null) {
            result.next = slow;
            slow = slow.next;
            result = result.next;
        }
        while (fast != null) {
            result.next = fast;
            fast = fast.next;
            result = result.next;
        }
        result.next = null;
        return first.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        int i = 0;
        ListNode secondPart = head;
        ListNode previous = head;
        while (secondPart != null && i < k) {
            previous = secondPart;
            secondPart = secondPart.next;
            i++;
        }
        if (i < k) return head;
        previous.next = null;
        ListNode reverse = reverseMyList(head);
        head.next = reverseKGroup(secondPart, k);
        return reverse;
    }

    private ListNode reverseMyList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }


}

class MyLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    private static class Node<T> {
        T value;
        Node<T> previous;
        Node<T> next;

        public Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public MyLinkedList() {

    }

    public T get(int index) {

        Node<T> current = head;
        while (index > 0 && current != null) {
            current = current.next;
            index--;
        }
        return current != null ? current.value : null ;
    }

    public void addAtTail(T val) {
        if (size == 0) {
            head = new Node<T>(val, null, null);
            tail = head;
        } else {
            tail.next = new Node<T>(val, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void addAtHead(T val) {
        if (size == 0) {
            head = new Node<T>(val, null, null);
            tail = head;
        } else {
            head.previous = new Node<T>(val, null, head);
            head = head.previous;
        }
        size++;
    }

    public void addAtIndex(int index, T val) {

        if(index>size) return;
        if(index==size){
            addAtTail(val);
        } else {
            Node<T> current = head;
            Node<T> prev = null;
            while (index>0){
                prev = current;
                current = current.next;
                index--;
            }

            Node<T> node = new Node<T>(val, prev, current);
            if(prev!=null){
                prev.next = node;
            } else{
                head = node;
            }
            if(current!=null){
                current.previous = node;
            }  else{
                head = node;
            }
            size++;
        }

    }

    public void deleteAtIndex(int index) {
        if(index<0 || index>size-1) return;
        Node<T> current = head;
        Node<T> prev = null;
        while (index>0){
            prev = current;
            current = current.next;
            index--;
        }
        if(current==head){
            Node<T> next = current.next;
            if(next!=null)   next.previous = null;
            head =head.next;
        } else if (current==tail) {
            prev.next = null;
            tail = prev;
        } else {
            Node<T> next = current.next;
            next.previous = prev;
            prev.next = next;
        }
        size--;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                '}';
    }
}