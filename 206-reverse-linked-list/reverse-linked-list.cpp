class Solution {
public:
    void helper(ListNode* Prev, ListNode* temp, ListNode*& head) { 
        if (temp == nullptr) {
            head = Prev; 
            return;
        }

        ListNode* Next = temp->next;
        temp->next = nullptr; 
        helper(temp, Next, head);
        temp->next = Prev; 
    }

    ListNode* reverseList(ListNode* head) {
        if (head == nullptr || head->next == nullptr) 
            return head;

        helper(nullptr, head, head);
        return head; 
    }
};