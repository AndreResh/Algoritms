package alg.linked_list;

import alg.domains.ListNode;

import java.util.*;

public class ThirdDayLinkedList {
    public static void main(String[] args) {
        System.out.println(new ThirdDayLinkedList().rotateRight(new ListNode(1), 1));
    }

    public int solve(ListNode A, int B) {
        ListNode slow = A;
        ListNode fast = A;
        int size = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            size++;
        }
        if (B > size) return -1;
        ListNode current = A;
        int i = size - B;
        while (i != 0) {
            current = current.next;
            i--;
        }
        return current.val;
    }

    public ListNode deleteDuplicates(ListNode A) {
        if (A == null) return null;
        ListNode head = A;
        ListNode first = head;
        ListNode previous = null;
        while (A != null) {
            if (previous != null && previous.val != A.val) {
                head.next = A;
                head = head.next;
            }
            previous = A;
            A = A.next;
        }
        head.next = null;
        return first;
    }

    public ListNode rotateRight(ListNode A, int B) {
        int size = 0;
        ListNode node = A;
        while (node != null) {
            node = node.next;
            size++;
        }
        B %= size;
        if (B == 0) return A;
        int k = size - B;

        ListNode head = A;
        ListNode previous = null;
        while (k != 0) {
            previous = head;
            head = head.next;
            k--;
        }
        if (previous != null) previous.next = null;
        ListNode first = head;
        previous = null;
        while (head != null) {
            previous = head;
            head = head.next;
        }
        if (previous != null) previous.next = A;
        return first;

    }

   

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.size()-1; i++) {
            int num = A.get(i)+1;
            if(set.contains(num)){
                list.add(A.get(i));
                continue;
            }
            list.add(num);
            set.add(num);
        }
        return list;
    }
}
