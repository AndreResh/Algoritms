package alg.algorithm;

import alg.domains.ListNode;

public class TenDay {
    public static void main(String[] args) {

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
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode main;
        while (head!=null){
            main = new ListNode(head.val, previous);
            previous = main;
            head = head.next;
        }
        return previous;
    }
}
