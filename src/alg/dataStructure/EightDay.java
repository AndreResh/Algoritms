package alg.dataStructure;

import alg.domains.ListNode;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class EightDay {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//        if (list.isEmpty()) return null;
//        Collections.reverse(list);
//        ListNode node = new ListNode(list.get(0));
//        ListNode first = node;
//        for (int i = 1; i < list.size(); i++) {
//            node.next = new ListNode(list.get(i));
//            node = node.next;
//        }
//        return first;


        ListNode previous = null;
        ListNode main;
        while (head!=null){
            main = new ListNode(head.val, previous);
            previous = main;
            head = head.next;
        }
        return previous;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode main = new ListNode(head.val);
        ListNode first = main;
        head = head.next;
        while (head != null) {
            if(main.val!=head.val){
                main.next = head;
                main = main.next;
            }
            head = head.next;
        }
        return first;
    }

}
