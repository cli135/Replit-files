/**
1. Two Sum
Easy

34332

1081

Add to List

Share
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // return method0(nums, target);
        return method1(nums, target);
        // return method2(nums, target);
        
    }
    
    // (O(n^2))
    public int[] method0(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] arr = {i, j};
                    return arr;
                }
            }
        }
        return new int[2]; // won't be returned but just
        // as a branch coverage case
    }
    
    // hashmap! basically a hashmap but mapping to 0s or 1s
    // absence or presence
    public int[] method1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // you need a hashmap for (value, index) pairs;
        // oops ok sounds good
        
        
        // yep we are tracking each value's index in a hashmap
        // as we go along, and if we find the perfect complement,
        // we can look up where that was in constant time
        // i could code my own array based hashmap if the memory size
        // was big enough - in fact, that is what i will do
        // although it will exceed memory limits
        for (int i = 0; i < nums.length; i++) {
            int numsJ = target - nums[i];
            if (map.containsKey(numsJ)) {
                // get the index of numsJ in the original nums array
                int[] arr = {i, map.get(numsJ)};
                return arr;
            }
            // otherwise, we add i to the set and keep going
            map.put(nums[i], i);
        }
        // shouldn't arrive here since guaranteed pair
        // but just in case for branching/compiling logic
        return new int[2];
    }
    
    // these are still pretty slow
    // i wonder if there is a faster method
    // sort and then two pointer method?]
    
    // won't run for some reason:
      //   java.lang.NullPointerException: Cannot invoke "java.util.Map$Entry.getKey()" because "<local4>" is null
      // at line 80, Solution.method2
      // at line 5, Solution.twoSum
      // at line 54, __DriverSolution__.__helper__
      // at line 87, __Driver__.main
    
    // but the logic appears right
    public int[] method2(int[] nums, int target) {
        // map from values to indices (reverse)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        System.out.println(map);
        // TreeMap is already sorted via binary search tree insertion
        
        // ok now,
        
        // Arrays.sort(nums); // when you sort you need to remember
        // where the indices were
        // better to make a hashmap yet again or something
        // cause the unsorted indices are the ones that need to be
        // returned, not the scrambled (sorted) numbers and their indices
        // int i = 0;
        Map.Entry<Integer, Integer> i = map.firstEntry();
        Map.Entry<Integer, Integer> j = map.lastEntry();
        System.out.println(i);
        System.out.println(j);
        
        // int j = nums.length - 1;
        // move the two pointers toward each other until they cross
        while ((int) i.getKey() <= (int) j.getKey()) {
            if (i.getValue() + j.getValue() == target) {
                int[] arr = {i.getKey(), j.getKey()};
                return arr;
            }
            // move left idx up you need to go higher
            else if (i.getValue() + j.getValue() < target) {
                i = map.higherEntry(i.getKey());
            }
            // move right idx down if you need to go lower
            else {
                j = map.lowerEntry(j.getKey());
            }
        }
        // since a sol'n is guaranteed shouldn't end up here
        // but just for compiler to be happy with returning
        // at all branches
        return new int[2];
    }
}
