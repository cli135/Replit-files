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
    TreeNode* trimBST(TreeNode* root, int low, int high) {
        // base case, return up the tree if we get to a nullptr place
        if (root == nullptr) {
            return root;
        }
        // go to bottom to trim in reverse
        // and avoid 'jumping' over nodes (if we were to go forward)
        trimBST(root->left, low, high);
        trimBST(root->right, low, high);
        // out of range, trim the tree here
        if (root->val < low || high < root->val) {
            // move up left if exists
            if (root->left != nullptr) {
                root->val = root->left->val;
                root->right = root->left->right;
                root->left = root->left->left; // do this last
                // to keep your line of contact to old root->left
                // until you're done
            }
            // move up right if exists
            else if (root->right != nullptr) {
                root->val = root->right->val;
                root->left = root->right->left;
                root->right = root->right->right; // do this last
            }
        }
        return root;
    }
};