/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        if(head.next.next == null){
            return head;
        }
        // Start at even position node.
        ListNode temp = head.next;
        ListNode prev = head;
        ListNode head2 = temp;;

        while (temp != null && temp.next != null) {
            ListNode Next = temp.next;
            prev.next = Next;

            prev = Next;
            temp.next = Next.next;
            Next.next = null;
            temp = temp.next;
            
        }

        temp = head;
        
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head2;
        return head;
    }
}