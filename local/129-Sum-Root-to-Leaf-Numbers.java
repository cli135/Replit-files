https://leetcode.com/problems/sum-root-to-leaf-numbers/



129. Sum Root to Leaf Numbers
Medium

You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

    For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.

Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

 

Example 1:

Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:

Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

 

Constraints:

    The number of nodes in the tree is in the range [1, 1000].
    0 <= Node.val <= 9
    The depth of the tree will not exceed 10.

Accepted
338,412
Submissions
650,661



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
    // lesson: when you need to sum over multiple paths, your recursive case should like like:
    // return sum(root.left) + sum(root.right);
    // you should be referencing both left and right and adding them up, and returning the sum.
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    // before is a running/accumulating place-valued sum of the trie numbers we have so far
    // as we depth-first-search down the tree
    public int sumNumbers(TreeNode root, int before) {
        // base case (first)
        if (root == null) {
            return 0; // nothing to start summing
        }
        
        // base case (last, a LEAF)
        // leaves have 2 null children;
        // want to avoid double counting w/ above base case
        boolean leaf = root.left == null && root.right == null;
        if (leaf) {
            return 10 * before + root.val; // nothing else to sum
            // just what we have so far
        }
        
        // recursive case
        // sum both paths (l and r)
        // in each path, bring along the previous digits and tack on the current one
        return sumNumbers(root.left, before * 10 + root.val) + sumNumbers(root.right, before * 10 + root.val);
    }
}
