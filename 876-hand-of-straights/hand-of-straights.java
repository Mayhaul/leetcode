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

            // iterate till we have formed a group.
            while(x < groupSize){

                // if there are insufficient values to form a group.
                if(pq.isEmpty())
                    return false;


                int curr = pq.poll();

                // if its equal then temporarily put it into temp array to put it back again.
                if(curr == prev){
                    temp.add(curr);
                }else if(curr > prev + 1){ // if not true that means the sequence of numbers wont be consecutive.
                    return false;
                }else{
                    // if everything is fine then u add that number to the group.
                    prev = curr;
                    x++;
                }
            }
            // put the temp values back to the min heap.
            for(int i : temp){
                pq.offer(i);
            }
        }
        return true;
    }
}