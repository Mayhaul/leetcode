/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);

        while(!Q.isEmpty()){
            int n = Q.size();

            for(int i = 0; i < n - 1; i++){
                Node node = Q.poll();
                if(node.left != null)
                    Q.offer(node.left);
                if(node.right != null)
                    Q.offer(node.right);
                node.next = Q.peek();
            }
            
            Node temp = Q.poll();

            if(temp.left != null)
                Q.offer(temp.left);
            if(temp.right != null)    
                Q.offer(temp.right);

            
        }
        return root;
    }
}