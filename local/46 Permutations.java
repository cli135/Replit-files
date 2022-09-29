class Solution {
    // search space is mandatory O(n!) space and time
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] included = new boolean[nums.length];
        List<Integer> curList = new ArrayList<>();
        backtrack(nums, 0, included, curList, list);
        return list;
    }
    
    // and also forward-track is a good way to do it
    // you could just call it a runner that runs everywhere
    // to do stuff
    private void backtrack(int[] nums, int idx, boolean[] included, List<Integer> curList, List<List<Integer>> list) {
        int n = nums.length;
        if (idx == n) {
            list.add(curList);
        }
        for (int i = 0; i < n; i++) {
            if (included[i] == false) {
                included[i] = true;
                List<Integer> newList = new ArrayList<>();
                for (int a : curList) {
                    newList.add(a);
                }
                // apparently when we backtrack we have to
                // create new lists as we are going through
                // i wonder if it is possible to just use one
                // singular list as we go through all the way
                // to save some memory. i bet there is.
                int savedIdx = curList.size();
                newList.add(nums[i]);
                backtrack(nums, idx + 1, included, newList, list);
                // curList.remove(savedIdx); // removing doesn't really work
                included[i] = false; // afterwards
            }
        }
    }
}
