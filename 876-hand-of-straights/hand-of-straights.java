class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            // impossible to arrange in given number of groups.
            return false;
        }

        // Min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Populate pq
        for (int i : hand) {
            pq.offer(i);
        }

        while (!pq.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int prev = pq.poll();
            int x = 1;
            while(x < groupSize){

                if(pq.isEmpty())
                    return false;

                int curr = pq.poll();
                if(curr == prev){
                    temp.add(curr);
                }else if(curr > prev + 1){
                    return false;
                }else{
                    prev = curr;
                    x++;
                }
            }
            for(int i : temp){
                pq.offer(i);
            }
        }
        return true;
    }
}