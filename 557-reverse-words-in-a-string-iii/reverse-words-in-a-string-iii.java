class Solution {
    public String reverseWords(String s) {
        int i = 0;
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();

        while (i < s.length()) {
            if (chars[i] == ' ') {
                ans.append(chars[i]);
                i++;
            } else {
                int j = i;
                while (j < chars.length && chars[j] != ' ') {
                    j++;
                }

                int y = i;
                int x = j - 1;
                while (y < x) {
                    char temp = chars[y];
                    chars[y] = chars[x];
                    chars[x] = temp;
                    y++;
                    x--;
                }

                while (i < j) {
                    ans.append(chars[i]);
                    i++;
                }
            }
        }
        return ans.toString();
    }
}