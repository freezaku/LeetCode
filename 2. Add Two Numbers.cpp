/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *res = new ListNode(0);
        ListNode *p = res;
        int adv = 0;
        
        while(l1 != NULL || l2 != NULL || adv != 0) {
            int ans = adv;
            if(l1 != NULL) {
                ans += l1->val;
                l1 = l1->next;
            }
            if(l2 != NULL) {
                ans += l2->val;
                l2 = l2->next;
            }
            
            p->next = new ListNode(ans % 10);
            p = p->next;
            adv = ans / 10;
        }
        
        return res->next;
    }
};
