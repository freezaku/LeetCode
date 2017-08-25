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
    /*
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if(m == n)  return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int index = 1;
        
        while(index < m) {
            pre = pre.next;
            index ++;
        }
        ListNode cur = pre.next;

        while(index < n) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            index ++;
        }
        
        return dummy.next;
    }
}

/*
注意计数的index的变化。

先不用想着怎么在程序上解决运行这个问题，先靠画图和思考
得到每一步该怎样操作，来得到最终的答案，然后再将其落实到程序。

此题中，pre始终保持在m之前的一个元素，pre.next指向暂时放在其后的元素，
cur.next指向最后一个元素，cur.next即为next为需要调转的元素a，其next指向需要调转的元素b。

通过画图能够更好的理解。
*/