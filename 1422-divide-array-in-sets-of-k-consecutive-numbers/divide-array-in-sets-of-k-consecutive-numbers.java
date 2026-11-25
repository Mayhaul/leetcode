class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {

        if (nums.length % k != 0)
            return false;

        HashMap<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Build frequency map
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Insert distinct elements into min heap
        for (int num : freq.keySet()) {
            pq.offer(num);
        }

        while (!pq.isEmpty()) {

            int first = pq.poll();

            // Skip elements already consumed
            if (!freq.containsKey(first))
                continue;

            int count = freq.get(first);

            for (int i = 0; i < k; i++) {

                int curr = first + i;

                if (!freq.containsKey(curr) || freq.get(curr) < count)
                    return false;

                int remaining = freq.get(curr) - count;

                if (remaining == 0) {
                    freq.remove(curr);
                } else {
                    freq.put(curr, remaining);
                }
            }
        }

        return true;
    }
}