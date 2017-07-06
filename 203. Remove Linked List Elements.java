/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)    return head;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        dummy.next = head;
        while(node != null && node.next != null) {
            while(node.next != null && node.next.val == val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return dummy.next;
    }
}

/*
ez题，注意一下node要先判断是否为null，再判断其next是否为null
*/