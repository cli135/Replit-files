/**

https://leetcode.com/problems/house-robber/

198. House Robber
Medium

13538

280

Add to List

Share
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
Accepted
1.2M
Submissions
2.6M
Seen this question in a real interview before?

*/

class Solution {
    public int rob(int[] nums) {
        // return rob(nums, 0);
        
        // memoization approach
        // fibgood
        
        // just pre-calculate each of f(n) before you have to use it
        // so you don't re-calculate it on the fly
        // memoization is just "remembering what you did before to save time now"
        // 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 = 8
        // now add an extra + 1 to LHS = 9
        // how did you do so fast? 
        // "i remembered"
        // dynamic programming is remembering what you did before in order to save time now
        
        // storing f(n)
        // max totals when starting at house i
        // and being able to rob any houses > i (to the right)
        // since we are going left to right

        // need some space to begin the recursively defined function
        // two base cases are both 0s
        int[] maxTotals = new int[nums.length + 2];

        
        for (int i = nums.length - 1; i >= 0; i--) {
            
            // base cases are the 0s beyond the end
            // the 1, 2 from left entries are constructed
            // recursively from doing the Math.max function with 0s
            
            // recursive case (working right to left)
            // to populate the dp grid / pascal's triangle
            
            // max of two choices:
            // rob this house and skip the next
            // skip this house and rob the next
                // really, it means (skip this house and max out the opportunity to have the ability to rob the next, which might mean abstaining again, but it gives you the opportunity to be on a good parity, etc., NFA cloning guessing style with a stroke of luck to hit the jackpot that you didn't even see coming)
            maxTotals[i] = Math.max(nums[i] + maxTotals[i + 2], maxTotals[i + 1]);
        }
        
        // there are two ways of looking at dp:
        
        // fibbad
        // recursive
        // repetition in recursive calls / trees
        // intuitive
        // straight from recurrence relation
        // functional == mathematically sound + easy to prove
        
        // fibgood
        // array based
        // ground up building pascals triangle
        // no repetition of calculations, no recalculating
        // pre-calculating once per calc
        // optimized, but
        // less intuitive
        // imperative - state based - harder to prove
        // faster + saves time
        
        // credit: carrara
        // https://www.youtube.com/c/Cararra
        
        // return the max of either
        // decision trees / universe splitting trees:
        // rob house 0 or skip house 0 (and all consequent alternate
        // universes that follow)
        return maxTotals[0];
        
    }
    // i is index in nums array
    private int rob(int[] nums, int i) {
        
        // base case to end the end recursion
        if (i >= nums.length) {
            return 0;
        }
//         for (int i = 0; i < nums.length; i++) {
//         }
        // this is like regex nfa automata parsing
        // you can take this and go r + 2, or
        // sometimes you just stay here and do r + 0
        
        // functional programming is awesome
        
        // either rob this house and skip the next one,
        // or don't rob this house and have the option
        // to rob the next one (really to be optimal
        // the next house should be robbed but i think
        // the Math.max function will take care of optimality
        // and maximizing here, i believe)
        
        return Math.max(nums[i] + rob(nums, i + 2), rob(nums, i + 1));
        
        // ohh this is the fibbad problem
        // all dp problems are basically fibonacci calculation
        // problems
        
        // ok so you need to switch to dp array style iterative
        // optimized memoization
        // instead of allowing stack call to do recursion for you
        // ok sounds good
        
        // this techincally mathematically works
        // as a recursively-defined recurrence relation.
        // it just, like fibbad and your automata alg,
        // runs in like O(n!) runtime i think so it won't work for
        // large functions. same with your branching subset alg, that's
        // like O(2^N) you probably need a bitmask or something
        // you did last time to find a way to encode subsets or
        // recurrence relations like this one. e.g. you need memoization
        // to avoid duplicate calculuations like in fibbad
        
    }
}
