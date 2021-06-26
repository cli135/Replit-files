/*
94. Binary Tree Inorder Traversal
Easy

Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]

Example 4:

Input: root = [1,2]
Output: [2,1]

Example 5:

Input: root = [1,null,2]
Output: [1,2]

 

Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

 
Follow up: Recursive solution is trivial, could you do it iteratively?
*/

/*
1. pushLeft (memory usage 70 %ile)
2. pureIterative (memory usage 40 %ile)
3. recursive (memory usage 30 %ile)
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
    public List<Integer> inorderTraversal(TreeNode root) {
        //List<Integer> list = new ArrayList<Integer>();
        //pushLeft(root, list); // iterative, using stack
        //inorder(root, list); // recursive
        //return list;
        
        // pure iterative
        return pureIterative(root);
        
    }
    // pure iterative
    private List<Integer> pureIterative(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>(); // returned list
        Stack<TreeNode> stk = new Stack<TreeNode>(); // call stack
        TreeNode cur = root; // runner
        boolean down = true;
        while ( (down && cur != null) || !stk.isEmpty()) {
            // run down left
            if (down && cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            // at bottom left, add to list
            else {
                cur = stk.pop();
                list.add(cur.val);
                // go right if needed
                if (cur.right != null) {
                    cur = cur.right;
                    down = true; // might go down left
                }
                else {
                    down = false; // going back up
                }
            }
        }
        return list;   
    }
    
    /*
    // from solutions
    // iterative-recursive helper functions
    private void pushLeft(TreeNode ptr, List<Integer> list) {
        // base case
        if (ptr == null) {
            return;
        }
        // going down the tree
        // pushing left into a stack
        Stack<TreeNode> stk = new Stack<TreeNode>();
        while (ptr != null) {
            stk.push(ptr);
            ptr = ptr.left;
        }
        // coming back up the tree
        // putting values into ArrayList
        // going right when necessary
        while (!stk.isEmpty()) {
            // add current center
            TreeNode center = stk.pop();
            list.add(center.val);
            // go down right branch recursively, if exists
            pushLeft(center.right, list);
        }
    }
    */
    
    // recursive
    /*
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // left, center, right
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    */
}
