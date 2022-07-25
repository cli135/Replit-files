/**

572. Subtree of Another Tree
Easy

5802

317

Add to List

Share
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

 

Example 1:


Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:


Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 

Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104
Accepted
517.7K
Submissions
1.1M
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // check if they are the same tree, base case / final ending case
        if (isSameTree(root, subRoot)) {
            return true;
        }
        // null pointer exception pre-check
        // if the root is null and they aren't the same tree,
        // there is no subtree matching the given subtree
        else if (root == null) {
            return false;
        }
        // search recursively for any children roots that might
        // end up being the same tree as the subroot
        else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }
    // helper function to determine whether two trees
    // are the same or not
    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true; // both null mean same
            // ending at the same point / leaf
        }
        else if (root1 == null || root2 == null) {
            return false; // only one null (xor) means not same
            // one has a branch that goes further than another
            // leaves don't coincide at the same point
        }
        else {
            // both known to be non-null
            // values must be same, and
            // left trees must be same (recursive check), and
            // right trees must be same (recursive check)
            return root1.val == root2.val && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        }
    }
}
