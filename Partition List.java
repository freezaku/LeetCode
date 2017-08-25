/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null || head.next == null)   return head;
        
        ListNode dummy1 = new ListNode(0);
        ListNode small = dummy1;
        ListNode dummy2 = new ListNode(0);
        ListNode big = dummy2;
        
        while(head != null) {
            if(head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        
        small.next = dummy2.next;
        big.next = null;
        return dummy1.next;
    }
}

/*
不需要in place完成
*/