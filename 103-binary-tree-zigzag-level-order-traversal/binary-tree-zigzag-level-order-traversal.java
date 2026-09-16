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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Q.offer(root);
        int level = 0;

        while(!Q.isEmpty()){
            int n = Q.size();
            List<Integer> arr = new ArrayList<>();

            for(int i = 0; i < n; i++){
                TreeNode temp = Q.poll();
                
                if(temp.left != null){
                    Q.offer(temp.left);
                }
                if(temp.right != null){
                    Q.offer(temp.right);
                }
                if(temp != null){
                    arr.add(temp.val);
                }
            }
            if(level % 2 != 0){
                Collections.reverse(arr);
            }
            ans.add(new ArrayList<Integer>(arr));
            level++;
        }
        return ans;
    }
}