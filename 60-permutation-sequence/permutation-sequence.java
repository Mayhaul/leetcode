class Solution {
    public static int fact(int n) {
        int result = 1;
        while (n > 1) {
            result *= n--;
        }
        return result;
    }

    public String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        // keeping it 0 indexed.
        k--;

        for(int i = 0; i < n; i++){
            str.append((char)(i + 49));
        }

        while(ans.length() != n){
            int len = str.length();
            
            int x = fact(len) / len;

            int idx = k / x;

            ans.append(str.charAt(idx));

            k = k % x;

            str.deleteCharAt(idx);
        }
    
        return ans.toString();
    }
}