class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            int x = (int) s.charAt(i) - 'a';
            int y = 26 - x;
            sum += y *(i + 1);
        }
        return sum;
    }
}