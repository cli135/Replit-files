class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = 1;
        int minProd = 1; //keep track of min
        // because one negative could switch the sign
        // on a dime -- we have a premonition to watch
        // out for this case
        int best = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // max product so far: either start here or accumulate
            // from our last starting point (since contiguity mandated)
            int temp = maxProd;
            maxProd = Math.max(minProd * nums[i], Math.max(nums[i], maxProd * nums[i]));
            // in case the min prod could flip us around here
            // meaning nums[i] would be negative
            // maxProd = Math.max(maxProd, minProd * nums[i]);

            // don't forget -- you're doing a n_i = f(n_i-1)
            // meaning that you need to temp save any variables that
            // are half changed on this cycle, so all changes
            // are made reflecting the old state, not the half intermediate
            // new state halfway through this function/stage
            
            // temp variables are awesome
            
            // the whole theme of this problem is also keeping track of the min
            // and using dp at each point to know the min product gathered so far
            // because you could switch on a dime to being max in case you see
            // a negative, which is what maxProd accounts for when doing minProd * nums[i]
            
            
            // min product so far: namely, negative extreme
            // is also kept track of, in 
            minProd = Math.min(minProd * nums[i], Math.min(nums[i], temp * nums[i]));
            // in case the max prod could flip us around here
            // meaning in the case that nums[i] is negative

            if (maxProd > best) {
                best = maxProd;
            }
            
        }
        return best;
    }
    
    public int maxProduct1(int[] nums) {
        int best = Integer.MIN_VALUE;
        int product = 1;
        // Kadane's algorithm but for products, not sums, still works??
        for (int i = 0; i < nums.length; i++) {
            product = Math.max(product * nums[i], nums[i]); // accumulate or start over
            best = Math.max(product, best);
        }
        return best;
    }
    // ahhh, kadane's algorithm doesn't take into account the idea that you might
    // go double negative. very interesting.
    
    // so there must be a way to dynamic programming this.
    // 1. brute force
    // 2. memo cache
    // 3. array style dynamic programming
}
