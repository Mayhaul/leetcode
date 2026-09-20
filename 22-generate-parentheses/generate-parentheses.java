class Solution {
    public void helper(int n, int open, int close, StringBuilder str, List<String> ans) {
        if (str.length() == 2 * n) {

            ans.add(str.toString());
            return;
        }
        if (open < n) {
            helper(n, open + 1, close, str.append('('), ans);
            str.deleteCharAt(str.length() - 1);
        }
        if (close < open) {
            helper(n, open, close + 1, str.append(')'), ans);
            str.deleteCharAt(str.length() - 1);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        helper(n, 0, 0, str, ans);

        return ans;
    }
}