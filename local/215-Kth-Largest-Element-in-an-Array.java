/**
215. Kth Largest Element in an Array
Medium

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

 

Constraints:

    1 <= k <= nums.length <= 104
    -104 <= nums[i] <= 104

Accepted
1.1M
Submissions
1.8M
*/

import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        //return findKthLargestWithHashSet(nums, k);
        //return findKthLargestWithoutHashSet(nums, k);
        return findKthLargestWithHashSet(nums, k);
        
    }
    
    public int findKthLargestWithHashSet(int[] nums, int k) {
        HashSet<Integer> alreadyFound = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);
        }
        int j = 1;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            // actually hashset is not needed because
            // duplicates are counted anyways.
            //if (alreadyFound.contains(cur)) {
            //    continue;
            //}
            // why n - j + 1
            // well n - k position is what we're looking at
            // well we're doing 1 counting so we're off by 1
            // so we do the + 1 on n - k.
            // e.g. n == 6 meaning indicies 0 to 5 normally by zero counting
            // but by 1 counting it's 1 thru 6.
            // reverse because kth largest
            // 6 thru 1.
            // so when k = 1, we want to refer to index 6 (1 counting).
            // we could have avoided this situation just by doing 0 counting.
            // but to keep consistent with the problem let's stick with 1 counting.
            // 
            if (j == (nums.length + 1) - k) {
                return cur;
            }
            else {
                j++;
            }
        }
        return -1;
    }
    
    private int findKthLargestWithoutHashSet(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // O(N)
        for (int i : nums) {
            pq.add(i); //O(lg(N))
        }
        int j = 0;
        // we don't need to keep a hashset, since it's
        // in sorted order, any duplicates will be adjacent
        // and can be found by checking if the current element
        // and its previous are equal.
        int cur = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            cur = pq.poll();
            if (j == nums.length - k) {
                return cur;
            }
            else {
                j++;
            }
        }
        return -1; // error flag
    }
    
    public int findKthLargestByPollingDuringAdding(int[] nums, int k) {
        // faster way
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
