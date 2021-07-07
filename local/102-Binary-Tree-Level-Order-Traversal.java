// https://leetcode.com/problems/binary-tree-level-order-traversal/

/*
 *102. Binary Tree Level Order Traversal
Medium

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []

 

Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -1000 <= Node.val <= 1000

Ac
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

// preorder version that is sequentially building the level lists, not parallelly building them. Not ideal but the ideal solution is after this.

class Solution {
    // returns list of list of levels
    public List<List<Integer>> levelOrder(TreeNode root) {
        int height = depth(root);
        List<List<Integer>> overallList = new ArrayList<List<Integer>>();
        // each level, add that vector to the overall list
        for (int i = 1; i <= height; i++) {
            List<Integer> list = new ArrayList<Integer>();
            // populate list with level
            level(root, 1, i, list);
            overallList.add(list);
        }
        return overallList;
    }
    // returns a list of integers on a specific level
    private void level(TreeNode root, int level, int goalLevel, List<Integer> list) {
        if (root == null) {
            return;
        }
        // depth-first-search, preorder
        // (to go left-to-right)
        // only outputting stuff for a particular level
        if (level == goalLevel) {
            list.add(root.val);
        }
        // recursive (l to r)
        // list is a reference to the same object (all along) in heap memory
        // so we're adding the same list
        // yep, it looks like List<Integer> is an object type
        // so we have references to the object in heap memory,
        // not the object itself
        level(root.left, level + 1, goalLevel, list);
        level(root.right, level + 1, goalLevel, list);
    }
    // returns depth of tree (num of levels)
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}

// ideal solution below: parallelly building lists via preorder traversal
