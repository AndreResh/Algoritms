package alg.ace_inteviev_1;

import alg.domains.ListNode;

public class ThirdDay {
    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = null;
        while(head!=null){
            current = new ListNode(head.val, previous);
            previous = current;
            head = head.next;
        }
        return current;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode main = new ListNode();
        ListNode first = main;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                main.next = list1;
                main = main.next;
                list1 = list1.next;
            } else{
                main.next = list2;
                main = main.next;
                list2 = list2.next;
            }
        }
        while(list1!=null){
            main.next = list1;
            main = main.next;
            list1 = list1.next;
        }
        while(list2!=null){
            main.next = list2;
            main = main.next;
            list2 = list2.next;
        }
        main.next = null;
        return first.next;

    }
}
