/**
78. Subsets
Medium

10999

165

Add to List

Share
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
Accepted
1.2M
Submissions
1.6M
Seen this question in a real interview
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // O(2^n) power set traversal
        // for each element, either include it or not
        // 2^n possibilities
        List<List<Integer>> soFar = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(nums, 0, cur, soFar);
        return soFar;
    }
    // this might be O(n * 2^n)
    // void methods are great for binary tree traversals
    // and backtracking in general instead of x = change(x)
    // parameter passing is good
    // just know when to make something void vs List<List<Integer>>
    // and also know when to deep copy the List<Integer>
    // so you don't reuse it on all paths and cause
    // confusion / overuse / doubling on the same list
    private void backtrack(int[] nums, int start, List<Integer> cur, List<List<Integer>> soFar) {
        
        for (int i = start; i < nums.length; i++) {
            // checking each element
            // whether we include it or not
            
            cur.add(nums[i]); // with
            backtrack(nums, i + 1, cur, soFar);
            cur.remove(cur.size() - 1); // without
        }
        // base case below
        soFar.add(new ArrayList<>(cur)); // deep copy works
        // start fresh each time
        // don't let neighbor routes in the binary tree
        // interfere with each others' memory
        // soFar.add(cur); // shallow copy doesn't work
    }
}
