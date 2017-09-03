/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)   return true;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode pre = slow;
        ListNode cur = pre.next;
        while(cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        
        ListNode ptr1 = head;
        ListNode ptr2 = pre.next;
        
        while(ptr1 != null && ptr2 != null) {
            if(ptr1.val != ptr2.val)    return false;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        return true;
    }
}

/*
利用快慢指针获取一半的list，将后一半进行reverse，
然后将前一半和reverse之后的的后一半进行比较
*/