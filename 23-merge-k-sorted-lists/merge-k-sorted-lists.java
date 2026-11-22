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
    public ListNode mergeKLists(ListNode[] lists) {

    // Key idea is to add all nodes in a MaxHeap PQ.
    // Maintain a temp = null (initially)
    // pop nodes in decending order
    // attach new nodes infront of temp and update temp to that node.
    // eventually temp will become head to the sorted list.

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b.val,a.val)
        );

        for (ListNode head : lists) {
            ListNode curr = head;

            while (curr != null) {
                pq.offer(curr);
                curr = curr.next;
            }
        }

        ListNode temp = null;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();

            node.next = temp;
            temp = node;
        }

    return temp;

    }
}