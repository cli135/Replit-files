// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

/**
 * 116. Populating Next Right Pointers in Each Node
Medium

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

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

Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.



Constraints:

    The number of nodes in the given tree is less than 4096.
    -1000 <= node.val <= 1000

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
    Node[] prev; // global tracker of previous entries
    public Node connect(Node root) {
        int depth = depth(root);
        prev = new Node[depth + 1]; // first entry unused
        // for 1-counting convenience
        // recursive right-to-left level order
        connect(root, 1);
        return root;
    }
    private void connect(Node root, int level) {
        if (root == null) {
            return;
        }
        // reverse preorder, to go right to left in the tree
        // right
        connect(root.right, level + 1);
        // left
        connect(root.left, level + 1);
        // center
        // assign link based on level
        root.next = prev[level];
        prev[level] = root;
    }
    // helper to calculate orig depth + num of elems in prev
    // this makes it O(lg n) memory, one for each layer. We want O(1) memory
    private int depth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
