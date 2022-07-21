/** 

// https://leetcode.com/problems/top-k-frequent-elements/

347. Top K Frequent Elements
Medium

10091

395

Add to List

Share
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

Accepted
1.1M
Submissions
1.6M
Seen this question in a real interview before?

*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // frequency distribution in its most ordinary sense
        // I believe we could just do ultimate manual hashing
        // and just use a huuuge array if test cases weren't so big
        
        Map<Integer, Integer> frequency = new HashMap<>();
        
        // don't quite understand this part
        List<Integer>[] buckets = new List[nums.length + 1];
        
        for (int num : nums) {
            // increment count
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        // debugging output
        System.out.println(frequency);
        
        for (int key : frequency.keySet()) {
            // flipping the map around
            // on its head - the other way
            int count = frequency.get(key);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            // store the num in its count category
            // flipping the map around
            buckets[count].add(key);
        }
        
        // debugging output
        for (List<Integer> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            for (int i = 0; i < bucket.size(); i++) {
                System.out.print(bucket.get(i) + " ");
            }
            System.out.println();
        }
            
        // starting from the back and gathering stuff
        // from frequency buckets until we are full and have k
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                // could also do a one liner with the comment below:
                // return result.addAll(buckets[i]);
                int j = 0;
                while (j < buckets[i].size() && result.size() < k) {
                    result.add(buckets[i].get(j));
                    j++; // forgot to increment in while loop oops
                }
            }
        }
        
        // conversion to array
        int[] ret = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ret[i] = result.get(i);
        }
        return ret;
        
        // could also do:
        // return result.subList(0, k);
        
        
        
    }
}
