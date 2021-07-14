// https://leetcode.com/problems/binary-tree-postorder-traversal/

/**
145. Binary Tree Postorder Traversal
Easy

Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]
Output: [3,2,1]

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
Output: [2,1]

 

Constraints:

    The number of the nodes in the tree is in the range [0, 100].
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
    public List<Integer> postorderTraversal(TreeNode root) {
        // huge help from jocelynayoga
        // https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
        // iterative postorder: adding the nodes to visit to a stack.
        // like the call stack
        Stack<TreeNode> stk = new Stack<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();
        TreeNode cur = root;
        if (root == null) {
            return list;
        }
        // while more nodes to visit
        while ( cur != null || !stk.isEmpty() ) {
            // going down
            if (cur != null) {
                stk.push(cur); // save point
                cur = cur.left; // go left first
            }
            else {
                // can't go left
                // explore right, then go up
                TreeNode node = stk.peek().right; // just peeking if there's a right track
                if (node == null) {
                    // no need to explore right, since we are done
                    // exploring the right
                    // we can pop the node
                    node = stk.pop();
                    list.add(node.val);
                    while (!stk.isEmpty() && stk.peek().right == node) {
                        node = stk.pop();
                        list.add(node.val);
                    } // while loop incase we had this before:
                    /**
                        *
                       /
                      /
                      \
                       \
                        \
                         *
                    */
                }
                else {
                    // otherwise, we need to explore the right
                    cur = node;
                }
            }
        }
        return list;
    }
}
