/**
238. Product of Array Except Self
Medium

12282

745

Add to List

Share
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

Accepted
1.2M
Submissions
1.8M
Seen this question in a real interview before?


*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProducts = new int[nums.length];
        int[] suffixProducts = new int[nums.length];
        // going forwards for prefix products, accumulating
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            prefixProducts[i] = prod;
        }
        // going backwards for suffix products now
        // still accumulating
        prod = 1; // reset
        for (int i = nums.length - 1; i >= 0; i--) {
            prod *= nums[i];
            suffixProducts[i] = prod;
            
        }
        
        // ok now for each element in the thing
        // its just the product of adjacent accumulated sums
        // like the tides all accumulated up to the sides
        // and you just dump it in to call it a day.
        // cool
        // this is staircase accumulation is what it is
        // shaffer hall cross upwards staircases
        int[] answer = new int[nums.length];
        for (int i = 1; i < nums.length - 1; i++) {
            answer[i] = prefixProducts[i - 1] * suffixProducts[i + 1];
        }
        
        // now we're gonna handle the first and last
        answer[0] = suffixProducts[1];
        answer[nums.length - 1] = prefixProducts[nums.length - 2];
        
        return answer;
    }
}
