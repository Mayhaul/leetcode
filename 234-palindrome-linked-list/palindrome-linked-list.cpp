/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    bool helper(ListNode* &head, ListNode* temp){
        if(!temp)
            return true;

        bool match = helper(head, temp->next);

        if(!match)
            return match;

        bool result = (temp->val == head->val);
        
        head = head->next;
        
        return result;
    }

    bool isPalindrome(ListNode* head) {
        return helper(head, head);
    }

};