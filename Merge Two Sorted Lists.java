Merge two sorted (ascending) linked lists and return it as a new sorted list. 
The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.

Have you met this question in a real interview? Yes
Example
Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.

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
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null && l2 == null)    return null;
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }
        
        ListNode res = new ListNode(0);
        ListNode pt = res;
        ListNode pt1 = l1;
        ListNode pt2 = l2;
        while(pt1 != null && pt2 != null) {
            if(pt1.val < pt2.val) {
                pt.next = pt1;
                pt1 = pt1.next;
            } else {
                pt.next = pt2;
                pt2 = pt2.next;
            }
            pt = pt.next;
        }
        if(pt1 != null) {
            pt.next = pt1;
        } else if (pt2 != null) {
            pt.next = pt2;
        }
        
        return res.next;
    }
}

/*
简单题
*/