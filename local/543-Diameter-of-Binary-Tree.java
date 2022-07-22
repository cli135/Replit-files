/**

// https://leetcode.com/problems/diameter-of-binary-tree/

543. Diameter of Binary Tree
Easy

8723

537

Add to List

Share
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
Accepted
805.3K
Submissions
1.5M
Seen this question in a real interview before?



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
    public int diameterOfBinaryTree(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        // recursive case
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        
        // no need for +1 because fencepost counting
        // counting paths between nodes means no +1 needed
        // you just add the depths on both sides to see
        // whether you want to go down at that point or not
        
        // if you don't want to go down at that point, that's fine
        // just use the max from a lower up-down that occurred lower
        // in the tree and take max of that
        
        // side note: i wish java had a way to take max of 3+ values
        // rather than nesting calls to Math.max()
        return Math.max(Math.max(left, right), maxDepth(root.left) + maxDepth(root.right));
    }
                        
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
