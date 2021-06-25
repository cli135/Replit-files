/*
114. Flatten Binary Tree to Linked List
Medium

Given the root of a binary tree, flatten the tree into a "linked list":

    The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
    The "linked list" should be in the same order as a pre-order traversal of the binary tree.

 

Example 1:

Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [0]
Output: [0]

 

Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -100 <= Node.val <= 100

 
Follow up: Can you flatten the tree in-place (with O(1) extra space)?
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
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        /*
        if (root == null) {
            return;
        }
        // go to leaves first
        flatten(root.right); // go right first
        flatten(root.left); // then go left (reverse preorder)
        // then address center
        root.right = prev; // link up previous flattened list
        prev = root; // adjust previous list head
        root.left = null; // eliminate double link if exists
        // prev comes up thru left and stores everything on the right side
        // so we can eliminate the double link
        // go back up in the reverse-preorder
        
        // How can I change my thinking to get it right next time?
        // 1. Reverse-preorder + global prev help with link changing
        // 2. The call stack goes down in the SAME order it came up, even if links changed
        // 3. If you want to iterate to the end (while node's next not null, node = node's next), consider going reverse. 
        */
        
    }
}
