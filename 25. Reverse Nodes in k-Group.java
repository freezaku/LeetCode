/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        
        ListNode p = head;
        int count = 0;
        while(p != null) {
            count ++;
            p = p.next;
        }
        int groups = count / k;
        
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        
        for(int i = 0; i < groups; i ++) {
            int num = 0;
            ListNode cur = pre.next;
            ListNode next = cur.next;

            while(num < k - 1) {
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = cur.next;
                num ++;
            }

            pre = cur;
        }
        
        return dummy.next;
    }
}

/*
主要思想就是先遍历一次计算长度，看有多少个group需要翻转。
然后对每个需要翻转的group，进行翻转，注意pre, cur, next的关系；
然后完成一次翻转后，更新pre；
*/