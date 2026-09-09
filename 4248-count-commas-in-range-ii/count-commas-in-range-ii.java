class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        long low = 1000;         
        long commas = 1;         

        while (low <= n) {
            long high = low * 1000 - 1; // Upper bound of current range
            
            // how many numbers fall into the current range 
            long count = Math.min(n, high) - low + 1;
            
            totalCommas += count * commas;
            
            low *= 1000; 
            commas++;     
        }

        return totalCommas;
    }
}