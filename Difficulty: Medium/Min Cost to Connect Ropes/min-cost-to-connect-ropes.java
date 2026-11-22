class Solution {
    public int minCost(int[] arr) {
        // code here
        
        // Min Heap
        PriorityQueue<Integer>pq = new PriorityQueue();
        
        int cost = 0;
        
        for(int i: arr){
            pq.offer(i);
        }
        
        // poll 2. add their sum to cost and offer their sum back.
        
        while(pq.size() > 1){
            int sum = pq.poll();
            sum += pq.poll();
            
            cost += sum;
            
            if(pq.isEmpty())
                break;
                
            pq.offer(sum);
        }
        
        return cost;
    }
}