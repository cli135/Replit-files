class Solution {
    
    public int maxProfit(int[] prices) {
        int l = 0; // the most recent min
        int r = 1; // the current point to sell
        int max = 0; // max profit
        while (r < prices.length) { // traverse all in time
            // can make a profit?
            if (prices[l] < prices[r]) {
                // remember the max
                max = Math.max(prices[r] - prices[l], max);
                // stay rooted at the current min
                // and see if we can make more
                r++;
            }
            // question: l is not really the global min
            // l is just the most recent min
            // where you drop down
            // l could be called the most recent drop point
            // i guess
            else {
                // drop?
                l = r; // jump to the next min point
                // start profit making again
                r++;
            }
        }
        return max;
    }
    
    // O(N) algorithm attempt
    // kadane's algorithm
    // accepted 8ms
    public int maxProfit0(int[] prices) {
        
        // this is some crazy code here that i don't
        // understand how it works
        int min = Integer.MAX_VALUE;
        int profitIfSoldToday = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // keep track of the last min
            min = Math.min(min, prices[i]);
            // check profit from last min
            profitIfSoldToday = prices[i] - min;
            // store max profit from last min
            max = Math.max(profitIfSoldToday, max);
            // it's all relative so you're comparing
            // profits based at different mins
            // but it's fine because you don't need
            // to remember where they came from, only
            // the magnitude of the profit
        }
        return max;
    }
        
    // O(N^2) algorithm, 202/211 cases passed, Time limit exceeded
    public int maxProfit1(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int curProfit = prices[j] - prices[i];
                if (curProfit > maxProfit) {
                    maxProfit = curProfit;
                }
            }
        }
        if (maxProfit < 0) {
            return 0;
        }
        else {
            return maxProfit;    
        }
    }
}
