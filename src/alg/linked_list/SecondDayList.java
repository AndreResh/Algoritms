package alg.linked_list;

import alg.domains.ListNode;
import alg.domains.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class SecondDayList {
    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head == null) return head;
        ListNode previous = null;
        ListNode current = head;
        int index = 1;
        while (current != null) {
            if (left == index) {
                ListNode reverse = reverseList(current, left, right);
                if (previous != null) {
                    previous.next = reverse;
                } else {
                    head = reverse;
                }
                break;

            }
            previous = current;
            current = current.next;
            index++;
        }
        return head;
    }

    private ListNode reverseList(ListNode current, int left, int right) {
        ListNode previous = null;
        ListNode first = current;
        while (left <= right) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            left++;
        }
        first.next = current;
        return previous;
    }

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int a : nums) {
            set.add(a);
        }
        int sum = 0;
        boolean contains = false;
        while (head != null) {
            if (set.contains(head.val)) {
                contains = true;
            } else {
                if (contains) {
                    sum++;
                    contains = false;
                }
            }
            head = head.next;
        }
        return contains ? sum + 1 : sum;
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode node = new ListNode();
        ListNode first = node;
        int sum = 0;
        while (head != null) {
            if (head.val == 0 && sum > 0) {
                node.next = new ListNode(sum);
                node = node.next;
                sum = 0;
            }
            sum += head.val;
            head = head.next;
        }
        return first.next;
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode headOfLess = null;
        ListNode currentOfLess = null;
        ListNode headOfMore = null;
        ListNode currentOfMore = null;
        while (head != null) {
            if (head.val < x) {
                if (headOfLess == null) {
                    headOfLess = head;
                    currentOfLess = head;
                } else {
                    currentOfLess.next = head;
                    currentOfLess = currentOfLess.next;
                }
            } else {
                if (headOfMore == null) {
                    headOfMore = head;
                    currentOfMore = head;
                } else {
                    currentOfMore.next = head;
                    currentOfMore = currentOfMore.next;
                }
            }
            head = head.next;
        }
        if (currentOfLess != null) {
            currentOfLess.next = headOfMore;
        }
        if (currentOfMore != null) {
            currentOfMore.next = null;
        }
        return headOfLess == null ? headOfMore : headOfLess;
    }

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node head) {
        Node prev = null;
        while (head != null) {
            prev = head;
            if (head.child != null) {
                Node tail = dfs(head.child);
                tail.next = head.next;
                if (head.next != null) {
                    head.next.prev = tail;
                }
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                head = tail.next;
                prev = tail;

            } else {
                head = head.next;
            }
        }
        return prev;
    }

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        ListNode previous = node;
        while (next != null) {
            node.val = next.val;
            previous = node;
            node = next;
            next = next.next;
        }
        previous.next = null;
    }

    public ListNode solve(ListNode A) {
        if(A==null) return null;
        ListNode head = null;
        ListNode first = null;
        ListNode tail = null;
        ListNode firstTail = null;
        while (A != null) {
            if (A.val == 1) {
                if (tail == null) {
                    tail = A;
                    firstTail = tail;
                } else {
                    tail.next = A;
                    tail = tail.next;
                }
            } else {
                if(head==null){
                    head = A;
                    first= head;
                } else {
                    head.next = A;
                    head = head.next;
                }
            }
            A = A.next;
        }
        if(tail!=null){
            tail.next = null;
        }
        if(head==null){
            return firstTail;
        }
        head.next = firstTail;

        return first;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode reverse = null;
        ListNode main = head;
        ListNode headCopy = getCopy(head);
        while (main!=null){
            ListNode next = main.next;
            main.next = reverse;
            reverse = main;
            main = next;
        }
        while (reverse!=null && headCopy!=null){
            System.out.println(reverse.val+" "+head.val);
            if(headCopy==reverse) return true;
            if(headCopy.val!=reverse.val){
                return false;
            }
            reverse = reverse.next;
            headCopy = headCopy.next;
        }
        return headCopy==null && reverse==null;
    }

    private ListNode getCopy(ListNode head) {
        if(head==null) return null;
        ListNode first = new ListNode();
        while (head!=null){
            first.next = new ListNode(head.val);
            first = first.next;
            head = head.next;
        }
        return first.next;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};