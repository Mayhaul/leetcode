class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int n = s1.length();

        for (int i = 0; i <= s2.length() - n; i++) {
            HashMap<Character, Integer> windowMap = new HashMap<>();

            for (int j = i; j < i + n; j++) {
                windowMap.put(s2.charAt(j), windowMap.getOrDefault(s2.charAt(j), 0) + 1);
            }
            if (windowMap.equals(map))
                return true;
        }
        return false;
    }
}