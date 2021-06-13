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
    bool isValidBST(TreeNode* root) {
        // base case
        if (root == nullptr) {
            return true;
        }
        // recursive case
        bool allInequalityTrue = allAreLessThan(root->left, root->val) && allAreGreaterThan(root->right, root->val);
        bool allChildrenValidBST = isValidBST(root->left) && isValidBST(root->right); 
        return allInequalityTrue && allChildrenValidBST;
    }
    // true if all in root are less than num
    // false otherwise (one counterexample is enough to make false)
    bool allAreLessThan(TreeNode * root, int num) {
        if (root == nullptr) {
            return true; // base case, vacuous
            // but important
        }
        if (root->val >= num) {
            return false;
        }
        return allAreLessThan(root->left, num) && allAreLessThan(root->right, num);
    }
    
    bool allAreGreaterThan(TreeNode * root, int num) {
        if (root == nullptr) {
            return true; // base case, vacuous
            // but important
        }
        if (root->val <= num) {
            return false;
        }
        return allAreGreaterThan(root->left, num) && allAreGreaterThan(root->right, num);
    }
    
    
};