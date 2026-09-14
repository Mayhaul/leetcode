/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = this.right = null;
    }
}*/

class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();

    public void helper(Node root, int level) {
        if (root == null) return;

        if (!set.contains(level)) {
            set.add(level);
            arr.add(root.data);
        }

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }

    public ArrayList<Integer> leftView(Node root) {
        arr.clear();
        set.clear();

        helper(root, 0);

        return arr;
    }
}