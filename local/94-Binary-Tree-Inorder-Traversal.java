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
pushLeft
pureIterative
recursive
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
        List<Integer> list = new ArrayList<Integer>();
        pushLeft(root, list); // iterative, using stacks in recursion
        //recursive(root, list); // recursion
        //list = pureIterative(root); // pure iterative, using 1 stack
        return list;
        
    }
    
    // pure iterative
    private List<Integer> pureIterative(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>(); // returned list
        Stack<TreeNode> stk = new Stack<TreeNode>(); // call stack
        TreeNode cur = root; // runner
        boolean down = true; // should go down or up?
        
        // while (going down) or (going up)
        while ( (down && cur != null) || !stk.isEmpty()) {
            // run down left
            // if we should and can
            if (down && cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            // going back up now
            else {
                // pop, add to list
                cur = stk.pop();
                list.add(cur.val);
                // explore right
                if (cur.right != null) {
                    cur = cur.right;
                    // should go down left again
                    down = true;
                }
                // otheriwse, should go back up
                else {
                    down = false;
                }
            }
        }
        // no more down && call stack empty
        return list;   
    }
    
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
    
    // recursive
    private void recursive(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // left, center, right
        recursive(root.left, list);
        list.add(root.val);
        recursive(root.right, list);
    }
    
}
