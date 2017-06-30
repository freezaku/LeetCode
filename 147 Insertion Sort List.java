/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)    return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;
            while(pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }
        return dummy.next;
    }
}

/*
构造dummy，但是不将dummy.next指向head，pre = dummy, cur = head

将head的每一个node逐一取下，赋给cur，每次都将其跟dummy即pre的next进行比较，
若pre.next < cur，则说明顺序正常，直到pre.next == null 或者 pre.next.val > cur，即将cur加入到pre之后。
*/