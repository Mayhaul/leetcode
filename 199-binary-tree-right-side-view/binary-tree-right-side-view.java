/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<Integer> arr;
    HashSet<Integer> set;

    public void helper(TreeNode root, int level) {
        if (root == null) return;

        if (!set.contains(level)) {
            set.add(level);
            arr.add(root.val);
        }

        helper(root.right, level + 1);
        helper(root.left, level + 1);
        
    }

    public ArrayList<Integer> rightSideView(TreeNode root) {
        arr = new ArrayList<>();
        set = new HashSet<>();

        helper(root, 0);
        return arr;
    }
}