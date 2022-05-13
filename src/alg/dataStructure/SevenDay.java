package alg.dataStructure;

import alg.domains.ListNode;

import java.util.HashSet;
import java.util.Set;

public class SevenDay {
    public boolean hasCycle(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//        while (head!=null){
//            head = head.next;
//            if(set.contains(head)) return true;
//            set.add(head);
//        }
//        return false;
        if(head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    public ListNode removeElements(ListNode head, int val) {
       ListNode current=new ListNode();
       ListNode first = current;
       while (head!=null){
           if(head.val!=val){
               current.next = new ListNode(head.val);
               current = current.next;
           }
           head=head.next;
       }
       return first.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode main =new ListNode();
        ListNode first = main;
        while (list1!=null && list2!=null){
            if(list1.val<list2.val){
                main.next=new ListNode(list1.val);
                main = main.next;
                list1 = list1.next;
            } else {
                main.next=new ListNode(list2.val);
                main = main.next;
                list2 = list2.next;
            }
        }
        while (list1!=null){
            main.next=new ListNode(list1.val);
            main = main.next;
            list1 = list1.next;
        }
        while (list2!=null){
            main.next=new ListNode(list2.val);
            main = main.next;
            list2 = list2.next;
        }

        return first.next;
    }

}
