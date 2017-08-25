/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if(head == null || head.next == null)   return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        int len = 0;
        while(fast != null) {
            fast = fast.next;
            len ++;
        }
        k = k % len;
        
        fast = dummy;
        for(int i = 0; i < k; i ++) {
            fast = fast.next;
        }
        while(fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}

/*
简单题
利用fast遍历整个list，先找出整个list的长度为i；
再利用slow，找到需要翻转的点的位置；
注意因为k的值可能大于长度i，所以将翻转位置进行转化j = i - k % i；
然后再画图得到将两部分重新连接的方法。

利用dummy来简化操作，画图来判断node的位置。
*/