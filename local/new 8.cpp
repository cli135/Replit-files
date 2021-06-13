/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    // use long? not int?
    int maxPathSum(TreeNode* root) {
        
    }
    int maxPathSumStartingAt(TreeNode * root) {
        if (root == nullptr) return 0;
        // find maxPathSum starting here
        int maxSum = root->val;
        int leftSum = maxPathSum(root->left);
        int rightSum = maxPathSum(root->right);
        // only adding the biggest (l or r)
        maxSum += max(leftSum, rightSum);
        return maxSum;
    }
};