// https://leetcode.com/problems/binary-tree-preorder-traversal/

/**
 * 144. Binary Tree Preorder Traversal
Easy

Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]

Example 4:

Input: root = [1,2]
Output: [1,2]

Example 5:

Input: root = [1,null,2]
Output: [1,2]

 

Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

 

Follow up: Recursive solution is trivial, could you do it iteratively?

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
    public List<Integer> preorderTraversal(TreeNode root) {
        // 1. rights
        //return preorderTraversalRights(root);
        // 2. stack both right and left on stack
        return preorderTraversalStackAll(root);
    }
    public List<Integer> preorderTraversalRights(TreeNode root) {    
        TreeNode cur = root;
        // rights stack inspired by pavel-shlyk
        // https://leetcode.com/problems/binary-tree-preorder-traversal/discuss/45266/Accepted-iterative-solution-in-Java-using-stack.
        Stack<TreeNode> rights = new Stack<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();
        
        // while (going down) or (going up)
        while ( (cur != null) || (!rights.isEmpty()) )  {
            if (cur != null) {
                // append value
                list.add(cur.val);
                // save point in stack
                rights.push(cur.right);
                // go left
                cur = cur.left;
            }
            else {
                // found null, go up and right
                cur = rights.pop();
            }
        }
        return list;
    }
    
    // stack both left and right
    // inspired by vegito2002
    // https://leetcode.com/problems/binary-tree-preorder-traversal/discuss/45267/3-iterative-solutions-stack-and-morris-traversal-complexity-explained
    public List<Integer> preorderTraversalStackAll(TreeNode root) {
        // stack stores both left and right
        Stack<TreeNode> stk = new Stack<TreeNode>();
        // arrayList copies O(N) on certain insertions (powers of 2 i think) to resize
        // LinkedList does not, is always constant front and back insertion. ofc, middle insertion is O(N/2) which is harder, but front and back insertion (which is what we're doing here) is good
        // the preorder list
        List<Integer> list = new LinkedList<Integer>();
        
        if (root == null) {
            return list;
        }
        
        // getting us started
        stk.push(root);
        
        
        // keep popping until nothing left
        while (!stk.isEmpty()) {
            // pop and add val to list
            TreeNode cur = stk.pop();
            // could do null check here
            // if (cur == null) continue;
            list.add(cur.val);
            // push right and left to stack, in that order
            // for preorder traversal (center, left, right)
            if (cur.right != null) {
                // proactive null check,
                // only non-nulls get added to stack
                stk.push(cur.right);
            }
            if (cur.left != null) {
                // only non-nulls added to stack
                // could also do the check before you
                // add to list
                stk.push(cur.left);
            }
            
        }
        return list;
    }
}
