/**

https://leetcode.com/problems/balanced-binary-tree/

110. Balanced Binary Tree
Easy

6583

344

Add to List

Share
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
Accepted
844.9K
Submissions
1.8M


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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true; // vacuous i think
        }
        // the last two isBalanced() calls tell it to go
        // recursively into each and every subtree in the tree
        // so no stone is left unturned -- at each layer,
        // we are searching for depth differences
        // very thoroughly
        // and of course at the current layer we are checking
        // for a depth difference greater than 1
        
        // and since have have a chain of &&'s
        // this means that vacuous truths are not very noteworthy
        // but a false value coming from a depth difference >= 2
        // is very noteworthy since that 'spoils' or 'contaminates'
        // the whole boolean and compound statement
        // in the recursive stack call and therefore
        // the tree is not balanced (because of the one exception)
        // that occurred at one lower level, or maybe even at
        // the current level
        return Math.abs(depth(root.left) - depth(root.right)) - 1 < 0.01 && isBalanced(root.left) && isBalanced(root.right);
        // these last two recursive calls basically just mean
        // (continue the search at lower levels just like you did here, replicate it there too - the essence of the BST invariant and other things recursive / nested / sub-nested in nature, not just at the current level, but check at the lower level ***as if the subtree were itself the original tree***)
    }
    
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
