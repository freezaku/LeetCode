You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1 s digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

Have you met this question in a real interview? Yes
Example
Given 7->1->6 + 5->9->2. That is, 617 + 295.

Return 2->1->9. That is 912.

Given 3->1->5 and 5->9->2, return 8->0->8.

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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null)  return l2;
        if(l2 == null)  return l1;
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int dev = 0;
        
        while(l1 != null || l2 != null) {
            int sum = dev;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            int digit = sum % 10;
            dev = sum / 10;
            cur.next = new ListNode(digit);
            cur = cur.next;
        }
        
        if(dev != 0) {
            cur.next = new ListNode(dev);
            cur = cur.next;
        }
        
        return dummy.next;
    }
}

/*
merge两个list，简单题
*/