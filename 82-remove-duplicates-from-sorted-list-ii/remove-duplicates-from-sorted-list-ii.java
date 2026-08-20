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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode temp = head;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;


        while(temp != null && temp.next != null){
            ListNode agla = temp.next;

            if(temp.val == agla.val){
                while(agla != null && temp.val == agla.val){
                    agla = agla.next;
                }
                prev.next = agla;
                temp = prev.next;
            } else{
                prev = temp;
                temp = agla;
            }
        }
        head = dummy.next;
        return head;
    }
}