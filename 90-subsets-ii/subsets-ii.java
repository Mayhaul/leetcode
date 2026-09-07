class Solution {
    public void helper(int[] nums, List<List<Integer>> ans, List<Integer> temp, int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // PICK
        temp.add(nums[idx]);
        helper(nums, ans, temp, idx + 1);
        temp.remove(temp.size() - 1); // Backtrack

        // Advance idx past all identical adjacent values for the DON'T PICK branch
        while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
            idx++;
        }

        // DON'T PICK
        helper(nums, ans, temp, idx + 1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort input upfront so duplicate values are adjacent
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        helper(nums, ans, temp, 0);
        return ans;
    }
}