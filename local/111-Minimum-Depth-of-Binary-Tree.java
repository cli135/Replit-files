111. Minimum Depth of Binary Tree
Easy

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 2

Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5


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
    public int minDepth(TreeNode root) {
        return minDepth(root, true);
    }
    public int minDepth(TreeNode root, boolean first) {
        if (root == null && first) {
            return 0; // first
        }
        // a null elsewhere means a dead end
        else if (root == null) {
            // no getting out of this haha
            // will not be the min
            return Integer.MAX_VALUE;
        }
        // a leaf
        if(root.left == null && root.right == null) {
            // one left
            return 1;
        }
        // pick the min path on either side
        // and go there
        return 1 + Math.min(minDepth(root.left, false), minDepth(root.right, false));
    }
} 

