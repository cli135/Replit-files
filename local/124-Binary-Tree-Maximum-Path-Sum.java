// https://leetcode.com/problems/binary-tree-maximum-path-sum/

/**
124. Binary Tree Maximum Path Sum
Hard

10525

563

Add to List

Share
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
Accepted
783.7K
Submissions
2.1M

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        traversePath(root);
        return maxValue;
    }
    // int return value
    // because there needs to be a way to tell you
    // what you got on a particular child node path
    private int traversePath(TreeNode root) {
        
        if (root == null) {
            return Integer.MIN_VALUE/3;
        }
        // why zeroes here
        // zeroes implicit for another root.val statement
        // try without zeroes
        // int leftMax = Math.max(0, traversePath(root.left));
        // int rightMax = Math.max(0, traversePath(root.right));
        int leftMax = traversePath(root.left);
        int rightMax = traversePath(root.right);
        // check going down at this point
        maxValue = Math.max(maxValue, root.val);
        maxValue = Math.max(maxValue, root.val + leftMax);
        maxValue = Math.max(maxValue, root.val + rightMax);
        maxValue = Math.max(maxValue, leftMax + root.val + rightMax);
        return Math.max(root.val, Math.max(leftMax, rightMax) + root.val); // need root.val and exactly one side for going up
        
    }
    
    
}
