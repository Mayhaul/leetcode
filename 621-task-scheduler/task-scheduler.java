class Task {
    public char c;
    public int freq;

    public Task(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}

// ALL THE CODE AND COMMENTS ARE HAND WRITTEN BY MEHUL VERMA. THIS AINT NO AI SLOP.

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        // to construct the answer.
        StringBuilder str = new StringBuilder();

        // Custom class custom comparator max heap.
        PriorityQueue<Task> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.freq, a.freq));

        for (char c : tasks) {
            // count freq;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            // put task object in PQ(MaxHeap) priority based on freq.
            Task t = new Task(c, map.get(c));
            pq.offer(t);
        }

        while (!pq.isEmpty()) {
            //to temporarily store the polled object.
            ArrayList<Task> store = new ArrayList<>();

            if (pq.size() <= n + 1) {

                int cycleSize = pq.size();

                for (int i = 0; i < cycleSize; i++) {
                    Task temp = pq.poll();
                    temp.freq--;

                    store.add(temp);
                    str.append(temp.c);
                }

                for (Task t : store) {
                    if (t.freq > 0) {
                        pq.offer(t);
                    } else {
                        map.remove(t.c);
                    }
                }

                if (!pq.isEmpty()) {
                    int idle = (n + 1) - cycleSize;

                    for (int i = 0; i < idle; i++) {
                        str.append(" ");
                    }
                }
            } else {
                for (int i = 0; i <= n; i++) {
                    Task temp = pq.poll();
                    temp.freq--;

                    store.add(temp);
                    str.append(temp.c);
                }

                for (Task t : store) {
                    if (t.freq > 0) {
                        pq.offer(t);
                    } else {
                        map.remove(t.c);
                    }
                }
            }

        }
        return str.length();
    }
}