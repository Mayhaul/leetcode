class Solution {
    public boolean isCompleteTree(TreeNode root) {

        // While moving from left to right did we ever find a null node? if yes then its invalid.

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean nullFound = false;

        while (!q.isEmpty()) {

            TreeNode temp = q.poll();

            if (temp == null) {
                nullFound = true;
            } else {

                if (nullFound) return false;

                q.offer(temp.left);
                q.offer(temp.right);
            }
        }

        return true;
    }
}