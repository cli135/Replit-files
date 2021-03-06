/**

100. Same Tree
Easy

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:

Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:

Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:

Input: p = [1,2,1], q = [1,1,2]
Output: false

 

Constraints:

    The number of nodes in both trees is in the range [0, 100].
    -104 <= Node.val <= 104

Accepted
741,890
Submissions
1,362,185
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeIterative(p, q);
        //return isSameTreeRecursive(p, q);
    }
    
    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        // base cases
        // nulls
        if (p == null) return q == null;
        if (q == null) return p == null;
        // val check and traverse
        Stack<List<Integer>> stk = new Stack<List<Integer>>();
        boolean diffFound = p.val != q.val;
        
        stk.push()
        while(!diffFound && !stk.empty()) {
            
        }
    }
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        // base cases
        // nulls
        if (p == null) return q == null;
        if (q == null) return p == null;
        // same vals here?
        if (p.val != q.val) return false;
        // check corresponding children
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
 
    // below code is from 7-22-2022 at 2:11am
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            // same - null
            return true;
        }
        else if (p == null || q == null) { // xor due to above first check
            // discrepancy - xor
            return false;
            
        }
        else {
            // check cur vals
            // and recursively check children are equal to
            // (at every level, go deeper and confirm children
            // of the children are equal too - nested, kind of like inception the movie)
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
