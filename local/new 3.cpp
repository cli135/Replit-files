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
    bool isSymmetric(TreeNode* root) {
        // empty trees are symmetric
        if (root == nullptr) {
            return true;
        }
        
        // recursive search, where left and right are mirrored-pointers on their respective sides
        return compareMirrored(root->left, root->right);
    }
    bool compareMirrored(TreeNode* left, TreeNode* right) {
        // Base case: these tip-of-branches are symmetric if both left and right are beyond-leaves
        if (left == nullptr && right == nullptr) {
            return true;
        }
        
        // A discrepancy: only one is null ==> not symmetric tip-of-branches.
        if (left == nullptr || right == nullptr) {
            return false;
        }
        
        // check values equal and check MIRRORED children are equal
        // (right and left are compared)
        return left->val == right->val && compareMirrored(left->left, right->right) && compareMirrored(left->right, right->left);
    }
};