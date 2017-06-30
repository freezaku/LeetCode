/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)   return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode preMiddle = slow;
        ListNode current = slow.next;
        while(current.next != null) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = preMiddle.next;
            preMiddle.next = next;
        }
        ListNode p1 = head;
        ListNode p2 = preMiddle.next;
        while(p1 != preMiddle) {
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }
}

/*
先找到中点，

再将中点后的部分按照reverse方法进行reverse，

最后将两部分进行merge。

关键就在于merge的方法，要好好学习体会。
*/