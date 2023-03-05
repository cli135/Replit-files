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
    public int goodNodes(TreeNode root) {
        // can't prune early, since you need to see
        // all nodes, e.g. you could add a 6 below the 1 node
        // on the right side and it'd be a good node
        // overall you can keep track of a max value seen on this path
        // or branch, so yeah that could work
        return goodNodes(root, Integer.MIN_VALUE); // this is fine i guess
        
    }
    public int goodNodes(TreeNode root, int maxValueSeenSoFarOnThisBranch) {
        if (root == null) {
            // base case, both the first and the last
            return 0; // empty tree has 0 nodes, let alone any good nodes
        }
        // recursive case
        // checking if this root.val is uphill from us / higher ground
        // or if it's same height that's fine too
        if (root.val >= maxValueSeenSoFarOnThisBranch) {
            // then we are good and we add 1 to our total
            int newMax = root.val;
            // the maxValueSeenSoFarOnThisBranch inherits
            // it's true meaning by the way we use it, i.e. we
            // pass it down on a branch and it does the thing
            return 1 + goodNodes(root.left, newMax) + goodNodes(root.right, newMax);
        }
        else {
            // then this root.val is less than the max we've seen on this branch
            // and we don't include it in our sum, but we move to lower trees
            return 0 + goodNodes(root.left, maxValueSeenSoFarOnThisBranch) + goodNodes(root.right, maxValueSeenSoFarOnThisBranch);
        }
    }
}
