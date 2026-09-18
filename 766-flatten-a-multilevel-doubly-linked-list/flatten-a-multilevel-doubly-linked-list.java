/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node tail;

    public Node helper(Node head){
        if (head == null)
            return head;

        Node temp = head;

        while (temp != null) {
            tail = temp;

            if (temp.child != null) {
                helper(temp.child);

                Node store = temp.next;

                // Connect temp to child
                temp.next = temp.child;
                temp.child.prev = temp;

                // Node tail = findTail(temp.child);

                if (tail != null)
                    tail.next = store;
                if (store != null)
                    store.prev = tail;

                temp.child = null;
                
            }
                temp = temp.next;

        }
        return head;
    }
    
    public Node flatten(Node head) {
        tail = null;
        helper(head);

        return head;
    }
}

// Optimized time complexity by maintaining a global tail variable which lets us avoid redundant N passes through the list.