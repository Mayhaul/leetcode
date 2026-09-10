class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int maxLen = 0;
        int startIdx = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    int currentLen = j - i + 1;
                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                        startIdx = i;
                    }
                }
            }
        }

        return s.substring(startIdx, startIdx + maxLen);
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}