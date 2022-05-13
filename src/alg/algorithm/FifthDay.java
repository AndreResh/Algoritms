package alg.algorithm;


import alg.domains.ListNode;

import java.util.ArrayList;
import java.util.List;

public class FifthDay {
    public static void main(String[] args) {
//        ListNode node7 = new ListNode(5);
//        ListNode node6 = new ListNode(4, node7);
//        ListNode node5 = new ListNode(3, node6);
//        ListNode node4 = new ListNode(2, node5);
//        ListNode node3 = new ListNode(1, node4);
//        ListNode node = new FifthDay().removeNthFromEnd(node3, 2);
//        while (node != null) {
//            System.out.println(node.getVal());
//            node = node.getNext();
//        }
    }
    //19. Remove Nth Node From End of List
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode first = head;
        while (head != null) {
            size++;
            head = head.next;
        }
        int previous = size - n;
        if (previous == 0) {
            first = first.next;
            return first;
        }
        int count = 0;
        ListNode main = first;
        while (first != null) {
            count++;
            if (count == previous) {
                first.next = first.next.next;
            }
            first = first.next;
        }
        return main;
    }

//    876. Middle of the Linked List
    public ListNode middleNode(ListNode head) {
//        ListNode node=head;
//        int size = 0;
//        while (head != null) {
//            size++;
//            head = head.getNext();
//        }
//        int middle = size / 2 + 1;
//        size=0;
//        while (node!=null){
//            size++;
//            if(size==middle){
//                return node;
//            }
//            node=node.getNext();
//        }
//        return node;

//        List<ListNode> list = new ArrayList<>();
//        while (head!=null){
//            list.add(head);
//            head = head.next;
//        }
//        if(list.size()%2==0){
//            return list.get(list.size()/2+1);
//        } else {
//            return list.get(list.size()/2);
//        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
