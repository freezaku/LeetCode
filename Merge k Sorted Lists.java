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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists == null || lists.size() == 0)  return null;
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        
        for(ListNode node: lists) {
            if(node == null)    continue;
            pq.add(node);
        }
        
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            node = node.next;
            if(node != null) {
                pq.add(node);
            }
        }
        
        return dummy.next;
    }
}

/*
简单题，利用pq解决。
*/