// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

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
    
    public TreeNode sortedArrayToBST(int[] nums) {
        // return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
        
        // special case, since we have a left/right asymmetry
        // and we can't do a 'sentinel' on only favoriting one side
        if (nums.length == 0) {
            return null;
        }
        TreeNode pre = new TreeNode();
        sortedArrayToBSTHelperEarlyLinks(nums, 0, nums.length - 1, pre, true);
        return pre.left; // arbitrarily chose left
        
    }
    
    // inclusive [left, right]
    // no sentinel, instead, we do x = change(x)
    // meaning we can take advantage of left and right symmetry
    public TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        // edge case
        if (left > right) {
            return null;
        }
        // the array is set up for l, r ptrs
        // wait just pass them as parameters
        // insert mid val
        TreeNode root = new TreeNode();
        int mid = (left + right) / 2;
        root.val = nums[mid];
        // recursively find the mid of left and right, and repeat on those
        // x = change(x); // pretty much, basically
        root.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, right);
        // return the root. we are returning references by value so we're good
        return root;
    }
    
    // early links, modifying, not using x = change(x); // and returning references by value
    // on firstCall, we only go down the left path (an asymmetric thing, inconvenient)
    public void sortedArrayToBSTHelperEarlyLinks(int[] nums, int left, int right, TreeNode node, boolean firstCall) {
        // nothing else to do
        if (left > right) {
            return;
        }
        // insert mid value
        int mid = (left + right) / 2;
        if (firstCall) {
            // we only look to children on first call
            node.left = new TreeNode(); // again, .left is arbitrary
            // due to having to pick one of left or right
            node.left.val = nums[mid];
            sortedArrayToBSTHelperEarlyLinks(nums, left, right, node.left, false);
            return;
        }
        else {
            // looking ahead to grandchildren on all calls after first
            // we need to know whether to create a node for left or right branch
            // ahead of time, so we can pass same-rooted links, not unattached
            // parameters or references to nodes
            int lMid = (left + mid - 1) / 2;
            int rMid = (mid + 1 + right) / 2;
            if (left <= mid - 1) {
                // filling out left side
                node.left = new TreeNode();
                node.left.val = nums[lMid];
                sortedArrayToBSTHelperEarlyLinks(nums, left, mid - 1, node.left, false);
            }
            if (mid + 1 <= right) {
                // filling out the right side
                node.right = new TreeNode();
                node.right.val = nums[rMid];
                sortedArrayToBSTHelperEarlyLinks(nums, mid + 1, right, node.right, false);
            }
        }
    }
}
