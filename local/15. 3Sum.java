// A lot of help from this link below:
// https://leetcode.com/problems/3sum/discuss/7402/Share-my-AC-C%2B%2B-solution-around-50ms-O(N*N)-with-explanation-and-comments

/**

https://leetcode.com/problems/3sum/

15. 3Sum
Medium

19819

1879

Add to List

Share
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
Accepted
2.1M
Submissions
6.7M
Seen this question in a real interview
*/

class Solution {
    
    // A lot of help from this link below:
    // https://leetcode.com/problems/3sum/discuss/7402/Share-my-AC-C%2B%2B-solution-around-50ms-O(N*N)-with-explanation-and-comments
    
    public List<List<Integer>> threeSum(int[] nums) {
        // two sum with two pointers
        // no hash map needed
        
        List<List<Integer>> list = new LinkedList<>();
        
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // skip duplicates in target
            }
            int target = -1 * nums[i];
            // trying to find twosum to meet target
            int start = i + 1; // sorted non decreasing order
            int end = nums.length - 1;
            // two pointers method
            while (start < end) {
                if (nums[start] + nums[end] == target) {
                    // found
                    List<Integer> triplet = new LinkedList<>();
                    triplet.add(nums[start]);
                    triplet.add(nums[end]);
                    triplet.add(-target);
                    list.add(triplet);
                    
                    // skip duplicates that are adjacent
                    while (start < end && nums[start] == triplet.get(0)) {
                        start++;
                    }
                    while (start < end && nums[end] == triplet.get(1)) {
                        end--;
                    }
                    // maybe other triples exist like this too
                    // so no break here
                }
                else if (nums[start] + nums[end] < target) {
                    start++; // start too low
                }
                else { // nums[start] + nums[end] > target
                    end--; // end too high
                }
            }
        }
        return list;
    }
}
