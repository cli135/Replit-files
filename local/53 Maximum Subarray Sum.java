/**

https://leetcode.com/problems/maximum-subarray/submissions/


53. Maximum Subarray
Medium

25170

1157

Add to List

Share
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.



*/

class Solution {
    public int maxSubArray(int[] nums) {
        int best = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 0 vs. nums[i] is just a one off preference
            // gather now or on next iteration
            // like 0 or negative
            // i believe...but i really still don't fully understand
            // UPDATE: nevermind, nums[i] is necessary for generality
            // is it also necessary for positive+negative mixed cases
            // not just all negative?
            sum = Math.max(nums[i], sum + nums[i]); // start here or keep on going
            // ahh this is good - zero would work on positive nums i believe
            // wait positive nums would just mean whole array is max subarr sum
            
            // ok, then
            // zero is good for mixed positive negative cases?
            
            // but not good for all negative cases
            
            
            // zero (only?) violates the principle of generalzing to all Z integers
            // i think so...
            
            // NOT max(sum, sum + arr[i]) this could result in skipping

            best = Math.max(best, sum); // always compare back to best,
            // the max variable in this case
        }
        return best;
    }
}
