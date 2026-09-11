class Solution {
    public int totalNumbers(int[] digits) {
        int total = 0;
        int[] freq = new int[10];
        for(int d: digits){
            freq[d]++;
        }

        for(int i = 100; i < 1000; i+=2){
            int d1 = i /100; // hundreds place
            int d2 = (i / 10) % 10; // tens
            int d3 = i % 10; // units

            freq[d1]--;
            freq[d2]--;
            freq[d3]--;

            // if there were enough digits to form the number then thier freq after using them will not get below 0;
            if(freq[d1] >= 0 && freq[d2] >= 0 && freq[d3] >= 0){
                total++;
            }

            freq[d1]++;
            freq[d2]++;
            freq[d3]++;
        }
        return total;
    }
}