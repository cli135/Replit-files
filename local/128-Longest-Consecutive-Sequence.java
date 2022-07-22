/** 

// https://leetcode.com/problems/longest-consecutive-sequence/

128. Longest Consecutive Sequence
Medium

12093

509

Add to List

Share
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
Accepted
821.4K
Submissions
1.7M
Seen this question in a real interview before?


*/

class Solution {
    
    /*
    idea:
    
    put all nums in a set.
    find those nums that are the start of a streak / dna strand.
    if it's the start, ride that strand/streak until you're done,
    all the way to the very end just like DNA polymerase III on
    the leading strand
    this way each nucleotide is hit exactly once,
    as a part of the partial order (kinda equivalence) class that is it part of
    whose representative member is the most upstream member
    of that streak.
    
    if it's not a starter, then just ignore it
    because DNA polymerase, well, idk if this is true, but it binds
    to zinc fingers and stuff like that and TATA boxes and can't
    just jump in anywhere, it only starts at the 'beginning'
    and here we mean the beginning of a strand / streak
    
    so that each element is traversed exactly once, during the streak
    that it is a part of (which started with the starter element for that streak, and we are only searching out starters and we find all starters). 
    */
    
    public int longestConsecutive(int[] nums) {
        // take advantage of the fact that you
        // should only check each streak once
        // and you can check whether something is
        // a start of a new streak by checking if n - 1
        // is already in the set
        // edge case
        if (nums.length == 0) {
            return 0;
        }
        
        // i'm going to assume uniqueness
        // no duplicate elements
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        // current streak stats
        int longest = 1;
        int curStreak = 1;
        boolean streakOn = false;
        
        // checking for adjacent elems.
        for (int num : set) {
            // start of a new streak
            // we are injecting ourselves directly
            // into the start of streaks
            // and traversing all of them like
            // dna polymerase
            // so each element is only reached exactly 1 time
            // as a part of the dna strand that was upstream
            // and the start of the streak
            
            // by def: each streak has exactly 1 start
            // representative member of the equivalence class
            // i guess you could say
            // although downstream flowing is not an equivalence
            // relation - i think it is a PARTIAL ORDER
            // ANTISYMMETRIC OMG
            // if a is downstream from b and b is downstream from a,
            // then a == b
            // partial orders still have representatives of their sets
            // it's just a preferred one, the one that is most upstream
            // the 'start' of the streak
            
            // partial orders - learn more from the expert himself,
            // dr. scheinerman
            curStreak = 1;
            if (!set.contains(num - 1)) {
                // start of a new streak;
                // we only start doing an inner loop
                // on start of a new streak
                // so each element is traversed exactly once
                // during the loop of the streak it is a part of
                // and there is no overlap between streaks
                // by def of this '(n-1) check'
                
                // keep on going as high as you can
                // checking for how high you can make the streak
                int y = num + 1;
                while (set.contains(y)) {
                    curStreak++;
                    y++;
                }
                // once you've hit the highest, check if
                // it broke the record
                if (curStreak > longest) {
                    longest = curStreak;
                }
            }
        }
        
        
        return longest;
        
    }
    
    // 71/72 test cases but brute force really
    public int almostPassedAll(int[] nums) {
        // int[] frequency = new int[100000000];
        // save above for later in case you really need it
        
        // edge case
        if (nums.length == 0) {
            return 0;
        }
        
        // i'm going to assume uniqueness
        // no duplicate elements
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        // current streak stats
        int longest = 1;
        int curStreak = 1;
        boolean streakOn = false;
        
        // checking for adjacent elems.
        for (int i = -1000000 ; i < 1000000; i++) {
            if (set.contains(i) && set.contains(i + 1)) {
                // consecutive seq. found
                curStreak++;
                if (curStreak > longest) {
                    longest = curStreak;
                }
            }
            else {
                // a break means we start over counting
                // again (adjacent elems.)
                curStreak = 1; // reset again
            }
        }
                
        return longest;
    }
}
