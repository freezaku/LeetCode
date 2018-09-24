/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    let tail;
    let head;
    let carry = 0;
    
    while (l1 || l2 || carry) {
        let sum = carry;
        if(l1) {
            sum += l1.val;
            l1 = l1.next;
        }
        if(l2) {
            sum += l2.val;
            l2 = l2.next;
        }
        
        carry = Math.floor(sum / 10);
        let node = new ListNode(sum % 10);
        
        if (!head) {
            tail = node;
            head = tail;
        } else {
            tail.next = node
            tail = tail.next
        }
    }

    return head
};