class Solution {
    public void helper(int n, StringBuilder str, List<String> ans) {
        if (str.length() == 2 * n) {
            if (validate(str)) {
                ans.add(str.toString());
            }
            return;
        }
        helper(n, str.append('('), ans);
        str.deleteCharAt(str.length() - 1);
        helper(n, str.append(')'), ans);
        str.deleteCharAt(str.length() - 1);
    }

    public boolean validate(StringBuilder str) {
        if (str == null) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        helper(n, str, ans);

        return ans;
    }
}