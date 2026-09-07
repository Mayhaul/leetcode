/*
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public Node helper(List<Integer> nodes, int idx){
        
        if(idx >= nodes.size() || nodes.get(idx) == null || nodes.get(idx) == -1)
            return null;
            
        Node root = new Node(nodes.get(idx));
        Node Left = helper(nodes, 2 *(idx) + 1);
        root.left = Left;
        Node Right = helper(nodes, 2* (idx) + 2);
        root.right = Right;
        
    return root;
    
    }
    public Node buildTree(List<Integer> nodes) {
        // code here
        Node root = helper(nodes, 0);
        return root;
        
    }
}