/**

https://leetcode.com/problems/trapping-rain-water/

42. Trapping Rain Water
Hard

20534

287

Add to List

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
Accepted
1.2M
Submissions
2.1M
Seen this question in a real interview
*/

class Solution {
    public int trap(int[] height) {
        // two pointers method
        
        return 0;
    }
    
    // The below method is almost correct
    // It runs in O(N^2) or worse time
    // There has to be a better method that doesn't
    // use the max value in the array as the height of the array
    // and having to go through O(N^2) times
    // e.g. two pointers
    // 318 / 322 test cases passed. Status: Time Limit Exceeded
    public int trapAlmostCorrect(int[] height) {
        // distill by layers first
        // like, distill off layers at
        // a time to make a 2d array
        // cross sectional
        int maxHeight = 0;
        for (int num : height) {
            if (num > maxHeight) {
                maxHeight = num;
            }
        }
        // vertical profile or cross-section,
        // as if we were archaeologically excavating
        
        /*
        [
            [0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0]
            [0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0]
            [0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1]
        ]
        */
        
        int[][] crossSection = new int[maxHeight][height.length];
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < height.length; j++) {
                // filling in this level / layer
                // with the on/off blocks at this elevation
                
                // if it is high enough
                if (height[j] >= i + 1) {
                    // fill in the block at that level
                    crossSection[i][j] = 1;    
                }
                else {
                    // no block this high / at this level
                    crossSection[i][j] = 0;
                }
            }
            
        }
        
        // printing right side up
        // since the terminal prints from top to bottom,
        // we have to traverse the array backwards
        // since the array is stored from 'top to bottom'
        // or at least it is printed that way
        for (int i = maxHeight - 1; i >= 0; i--) {
            int[] layer = crossSection[i];
            System.out.println(Arrays.toString(layer));
        }
        
        // number of water blocks total trapped
        int totalCount = 0;
        
        // going across each layer and filling it up
        for (int i = 0; i < maxHeight; i++) {
            int countZeroes = 0;
            for (int j = 0; j < height.length; j++) {
                // count the number of zeroes in the row
                // minus the number of starting zeroes
                // and minus the number of ending zeroes
                // which are not 'walled in' by the axes
                // in the case of only 1 block, then
                // this sum equals 0
                if (crossSection[i][j] == 0) {
                    countZeroes++;
                }                
            }
            int countStartingZeroes = 0;
            for (int j = 0; j < height.length; j++) {
                if (crossSection[i][j] == 1) {
                    break;
                }
                else if (crossSection[i][j] == 0) {
                    countStartingZeroes++;
                }
            }
            int countEndingZeroes = 0;
            for (int j = height.length - 1; j >= 0; j--) {
                if (crossSection[i][j] == 1) {
                    break;
                }
                else if (crossSection[i][j] == 0) {
                    countEndingZeroes++;
                }
            }
            totalCount += (countZeroes - countStartingZeroes - countEndingZeroes);
        }
        
        return totalCount;
    }
}
