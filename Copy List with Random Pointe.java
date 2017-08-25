/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head == null)    return head;
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while(node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        
        node = head;
        while(node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        
        return map.get(head);
    }
}

/*
利用hashmap存储node和其复制的元素。
然后对于每个复制的元素，将其next和random指针按上去。
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head == null)    return head;
        
        RandomListNode iter = head;
        RandomListNode next = null;
        while(iter != null) {
            next = iter.next;
            RandomListNode copyOne = new RandomListNode(iter.label);
            iter.next = copyOne;
            copyOne.next = next;
            iter = next;
        }
        
        iter = head;
        while(iter != null) {
            if(iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        
        iter = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode res = dummy;
        while(iter != null) {
            next = iter.next.next;
            
            res.next = iter.next;
            res = res.next;
            
            iter.next = next;
            iter = iter.next;
        }
        
        return dummy.next;
    }
}

/*
不使用map解决。
在每一个元素之后加上一个复制元素，
然后将复制元素拆下来进行连接。
*/