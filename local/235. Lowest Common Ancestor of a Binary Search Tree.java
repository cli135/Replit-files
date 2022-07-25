/**

https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

235. Lowest Common Ancestor of a Binary Search Tree
Easy

6534

209

Add to List

Share
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [2,1], p = 2, q = 1
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.
Accepted
851.9K
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
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // take advantage of the binary search tree (BST) invariant
        // not just any old binary tree
        // a binary search tree (BST)
        
        // cases:
        
        // p, q on left side of root
        if (p.val < root.val && q.val < root.val) {
            // pursue left side
            return lowestCommonAncestor(root.left, p, q);
        }
        // p, q on right side of root
        else if (p.val > root.val && q.val > root.val) {
            // further pursue right side
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            // p, q on either sides of the fork in the road
            // this is the lowest common ancestor
            // base case (either beginning or end)
            return root;
        }
    }
    
    // helper function unused for current approach
    // this was part of my earlier, self-misguided approach
    // where i thought of just binary trees and not 
    // binary search trees (BSTs)
    // with BST invariant
    
    // a BST is the child of
    // a linked list (O(1) insertion time)
    // plus
    // a sorted, binary-searchable array (O(log n) lookup time)
    
    // so your access points are the middle of each section (binary searchable array)
    // and you can insert leaves or middle nodes anywhere (linked list)
    // to shift the whole linked tree structure and underlying inorder array structure (both)
    
    private boolean isDescendant(TreeNode root, TreeNode target) {
        if (root == target) {
            return true; // found the descendant in root
            // either at the beginning or at the end
        }
        else if (root == null) {
            return false; // null ptr exception prevention
        }
        return isDescendant(root.left, target) || isDescendant(root.right, target);
        // branching recursion is okay since i think this is still O(log n) i believe
    }
}s
