class Solution {
    public int lastStoneWeight(int[] stones) {
        // MaxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : stones){
            pq.offer(i);
        }

        while(pq.size() > 1){
            // because y >= x

            int y = pq.poll();
            int x = pq.poll();

            if(x != y){
                pq.offer(y - x);
            }
        }

        if(pq.size() == 1){
            return pq.poll();
        }

        return 0;

    }
}