/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> arr;
    HashSet<Integer> set;

    public void helper(Node root, int level) {
        if (root == null) return;

        if (!set.contains(level)) {
            set.add(level);
            arr.add(root.data);
        }
        
        helper(root.right, level + 1);
        helper(root.left, level + 1);
    }

    public ArrayList<Integer> rightView(Node root) {
        arr = new ArrayList<>();
        set = new HashSet<>();

        helper(root, 0);

        return arr;
    }
}