class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            
            hm.put(ch,hm.getOrDefault(ch,0)+1);

            while(hm.get(ch) > 1){
                char leftChar = s.charAt(left);
                hm.put(leftChar, hm.get(leftChar) - 1);

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}