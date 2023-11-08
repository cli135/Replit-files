class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, target, 0, 0);
    }
    // ok but this could be optimized
    // now do memo cache
    HashMap<String, Integer> cache = new HashMap<>();
    private int findTargetSumWays(int[] nums, int target, int i, int runningSum) {
        if (cache.containsKey(i + "," + runningSum)) {
            return cache.get(i + "," + runningSum);
        }
        if (i >= nums.length) {
            if (runningSum == target) {
                return 1;
            }
            else {
                return 0;
            }
        }
        // exponential time so far
        
        int count1 = findTargetSumWays(nums, target, i + 1, runningSum + nums[i]);
        cache.put((i + 1) + "," + (runningSum + nums[i]), count1);
        
        int count2 = findTargetSumWays(nums, target, i + 1, runningSum - nums[i]);
        cache.put((i + 1) + "," + (runningSum - nums[i]), count2);
        
        cache.put(i + "," + runningSum, count1 + count2);
        return count1 + count2;
        
    }
}
