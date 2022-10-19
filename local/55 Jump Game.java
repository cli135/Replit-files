class Solution {
    HashMap<Integer, Boolean> cache = new HashMap<>();
    public boolean canJump(int[] nums) {
        // return canJump(nums, 0);
        int max = 0; // max idx able to reach
        
        // this for loop is kind of like
        // we are building out our max reach / finding it
        // as we are testing the boundaries of how far
        // we can go
        // like a building the plane as we fly,
        // or a building the bridge as we walk
        // type of scenario
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                // then we can't even get to this point
                // hypothetical is useless
                return false;
            }
            else {
                // then we can get to this point
                // update the max then
                // which is globally how far we can get
                max = Math.max(nums[i] + i, max);
            }
        }
        // as long as we can get to the end of the array
        // or past it, then great
        return max >= nums.length - 1;
    }
    
    // below recursive is like 75/150 but TLEs on long ones
    // even after memo optimization? i guess i didn't do it right
    public boolean canJump(int[] nums, int i) {
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        
        if (i >= nums.length - 1) {
            cache.put(i, true);
            return true;
        }
        else if (nums[i] == 0) {
            cache.put(i, false);
            return false;
        }
        else {
            boolean result = false;
            for (int j = 1; j <= nums[i]; j++) {
                boolean temp = canJump(nums, i + j);
                cache.put(i + j, temp);
                result = result || temp;
            }
            cache.put(i, result);
            return result;
        }
    }
}
