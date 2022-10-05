class Solution {
    
    public int climbStairs(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return climbStairsHelper(n, cache);
    }
    
    private int climbStairsHelper(int n, Map<Integer, Integer> cache) {
        if (n == 0 || n == 1) {
            return 1; // base case
        }
        else if (cache.containsKey(n)) {
            return cache.get(n); // fetch from cache
        }
        else {
            // recursion fibonacci
            int first = climbStairsHelper(n - 1, cache);
            int second = climbStairsHelper(n - 2, cache);
            cache.put(n, first + second); // update cache
            return first + second;                  
        }       
    }
}
