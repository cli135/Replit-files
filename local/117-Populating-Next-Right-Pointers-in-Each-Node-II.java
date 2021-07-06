// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

/*
 *Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

    You may only use constant extra space.
    Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

 

Example 1:

Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

 

Constraints:

    The number of nodes in the given tree is less than 6000.
    -100 <= node.val <= 100


 *
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    Node prev = null;
    public Node connect(Node root) {
        int height = depth(root);
        // 1 <= i <= height
        for (int i = 1; i <= height; i++) {
            int goalLevel = i;
            connect(root, 1, goalLevel);
            // reset prev each level
            // no inter-level links
            prev = null;
        }
        return root;
    }
    private void connect(Node node, int level, int goalLevel) {
        if (node == null) {
            return;
        }
        // reverse preorder, to go right-to-left level order
        // remember to call recursive helper function
        connect(node.right, level + 1, goalLevel);
        connect(node.left, level + 1, goalLevel);
        if (level == goalLevel) {
            node.next = prev;
            prev = node;
        }
    }
    private int depth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
