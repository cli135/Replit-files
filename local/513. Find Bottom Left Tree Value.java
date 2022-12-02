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
    public int findBottomLeftValue(TreeNode root) {
        // find depth
        Integer result = findBottomLeftValue(root, depth(root));
        System.out.println(depth(root));
        return result;
    }
    // preorder traversal simulating level order traversal
    public Integer findBottomLeftValue(TreeNode root, int i) {
        if (root == null) {
            return null;
        }
        // good depth
        if (i == 1) {
            return root.val;
        }
        Integer left = findBottomLeftValue(root.left, i - 1);
        if (left != null) {
            return left;
        }
        
        Integer right = findBottomLeftValue(root.right, i - 1);
        if (right != null) {
            return right;
        }
        
        // edge case below to detect errors
        return null; // shouldn't run
        // sometimes your shouldn't run case
        // should actually run
        // and it should be null because it means that
        // both children are null and you need to go back up
    }
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
