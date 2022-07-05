/**
217. Contains Duplicate
Easy

5419

974

Add to List

Share
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
Accepted
1.8M
Submissions
2.9M
Seen this question in a real interview before?


*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // return method0(nums); // O(n^2)
        // return method1(nums); // O(nlogn + n) ==> O(nlogn)
        // return method2(nums); // O(n) amortized average case
        return method3(nums); // O(n) time truly, but memory is huuge (like (O(N)) but maybe higher)
    }
    // O(N^2) - time limit exceeded
    public boolean method0(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;   
                }
            }
        }
        return false;
    }
    // O(Nlogn + N)
    public boolean method1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
    // hash set O(N) amortized average case
    public boolean method2(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) {
            if (hs.contains(num)) {
                return true;
            }
            hs.add(num);
        }
        return false;
    }
    
    
    // method3 possible bucket sorting
    // basically coding hash table from scratch
    // but taking the space time tradeoff to the extreme
    // most space used, but fastest o(1) true time
    // like the distribution / frequency / count / median array
    
    
    // memory limit exceeded -- ok so only method 1 and 2 pass the leetcode test cases cause they really optimized the hash set to work well cool
    public boolean method3(int[] nums) {
        // twos complement mapping
        // 2 billion + 1
        int[] distribution = new int[2000000001];
        for (int num : nums) {
            // two's complement reverse mapping
            // to fit it into the array
            if (num < 0) {
                // -1 gets mapped to 1billion + 1 and we
                // count up from there
                // a rather ad-hoc and messy mapping
                // but it is what it is
                num += 1000000000 + 1 + 1;
            }
            
            if (distribution[num] == 1) {
                // always include your brackets in java
                return true; // already in hash set,
                // duplicate found
            } 
            distribution[num] = 1;
        }
        return false;
    }
    
    
}   
