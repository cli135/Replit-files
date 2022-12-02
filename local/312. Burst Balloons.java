// Time limit exceeded 12-2-2022 approx

class Solution {
    
    // memoization? well we would need a List
    // instead of an array in the first place
    // because this link says so:
    // https://stackoverflow.com/questions/15576009/how-to-make-hashmap-work-with-arrays-as-key
    // so i guess that i should just think of bottom up dp
    // it's kind of like 0-1 knapsack but idrk what that means
    // anyways
    public int maxCoinsBruteForce(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            // only one left
            return nums[0];
        }
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            // removing this one
            int[] hypo = new int[n - 1];
            int k = 0;
            for (int j = 0; j < n && k < n - 1; j++) {
                if (i == j) {
                    continue;
                }
                else {
                    hypo[k] = nums[j];
                    k++;
                }
            }
            values[i] = 1;
            if (i >= 1) {
                values[i] *= nums[i - 1];
            }
            if (i <= n - 2) {
                values[i] *= nums[i + 1];
            }
            values[i] *= nums[i];
            
            values[i] += maxCoins(hypo);
        }
        int max = Integer.MIN_VALUE;
        for (int val : values) {
            max = Math.max(max, val);
        }
        return max;
    }
    
    public int maxCoins(int[] nums) {
        return maxCoinsBruteForce(nums);
        /*
        // brute force is factorial time
        // i think this is 1d dp
        // or it might be 2d dp then
        // i'll try 2d dp
        // what are my two dimensions
        // bottom up dp requires thinking about last balloon
        // you will pop, and 2nd to last too
        // n^2 operation by hypotheticals as to who is next to you?
        // so i guess going bottom up?
        // dp is about foresight by constructing solutions ground-up optimally
        int n = nums.length;
        int[][] dp = new int[n][n];
        // base case for who is next to you in the last one
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1) {
                    dp[i][j] = nums[j];    
                }
                else {
                    for (int k = 0; k < n; k++) {
                        if (k == j) {
                            continue; // skip yourself
                        }
                        else {
                            
                        }
                    }
                }
                
            }
        }
        */
        
    }
}
