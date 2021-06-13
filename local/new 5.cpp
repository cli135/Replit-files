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
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> paths = {{}};
        // modify paths
        pathSum(root, targetSum, paths);
        return paths;
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum, vector<vector<int>> & paths) {
        if (root == nullptr) return paths;
        // leaf just meets remaining total ==> add to paths
        bool leaf = root->left == nullptr && root->right == nullptr;
        if (leaf && root->val == targetSum) {
            paths.push_back();
        }
    }
};