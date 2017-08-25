/**
 * Definition for ListNode
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
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null || head.next == null)   return head;
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while(head != null) {
            if(head.next != null && head.val == head.next.val) {
               int val = head.val;
               while(head != null && head.val == val) {
                   head = head.next;
               }
               continue;
            }
            cur.next = head;
            cur = cur.next;
            head = head.next;
        }
        
        cur.next = null;
        return dummy.next;
    }
}

/*
关键在于当head.val == head.next.val 的时候，直接将head进行处理知道不符合条件为止，然后直接continue，
因为最后得到的head仍然有可能和之后的ndoe又相同元素，
只有当一开始就不符合head.val == head.next.val条件的时候，
才移动cur指针，将node加到dummy之后
*/