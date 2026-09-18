class Solution {
    int count;
    int sum;
    HashMap<TreeNode, Integer> map;

    int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        int currSum = leftSum + rightSum + root.val;

        int n = map.get(root);

        if(currSum/n == root.val) count++;
        
        return currSum;
    }


    public int counter(TreeNode root){
        if(root == null) return 0;
        int res = counter(root.left) + counter(root.right) + 1;
        map.put(root,res);

        return res;
    }

    public int averageOfSubtree(TreeNode root) {
        count = 0;
        sum = 0;
        map = new HashMap<>();
        counter(root);
        helper(root);

        return count;
    }
}