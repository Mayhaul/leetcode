class Pair {
    public int first;
    public int second;
    public int i;
    public int j;

    public Pair(int first, int second, int i, int j) {
        this.first = first;
        this.second = second;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                a.first + a.second,
                b.first + b.second
            )
        );

        List<List<Integer>> ans = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return ans;

        // Insert the first element of each row.
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.offer(new Pair(nums1[i], nums2[0], i, 0));
        }

        while (ans.size() < k && !pq.isEmpty()) {

            Pair p = pq.poll();

            List<Integer> temp = new ArrayList<>();
            temp.add(p.first);
            temp.add(p.second);

            ans.add(temp);

            // Insert the next element from the same row.
            int nextJ = p.j + 1;

            if (nextJ < nums2.length) {
                pq.offer(new Pair(
                    nums1[p.i],
                    nums2[nextJ],
                    p.i,
                    nextJ
                ));
            }
        }

        return ans;
    }
}

// add k pairs into the heap.
// the pairs should contain all elements from nums1 mapped to first element of nums2.
// also store their indexes so we know which next pair to add.
// then we add the next pair from the latest popped pair.