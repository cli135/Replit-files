// currently not working
// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    // currently not working
    // time limit exceeded: lesson: don't do O(n^2) sorting / binary search / random access on a list.
    // lists are made for sequential access
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBSTHelper(head, 0, length(head) - 1);
    }
    // x = change(x) helper
    // no need to pass root though, since it's like x = create(l, r)
    public TreeNode sortedListToBSTHelper(ListNode head, int left, int right) {
        // base case
        if (head == null) {
            return null;
        }
        // else, find the mid and insert
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(get(mid, head));
        // recursively create and assign back to left and right.
        // not pure functional here
        root.left = sortedListToBSTHelper(head, left, mid - 1);
        root.right = sortedListToBSTHelper(head, mid + 1, right);
        return root;
    }
    
    public int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
    
    // returns the value at index in linked list
    public int get(int index, ListNode head) {
        if (index >= length(head)) {
            return -1; // error
        }
        // traversing until finding node at index
        int i = 0;
        ListNode cur = head;
        while (i < index) {
            cur = cur.next;
            i++;
        }
        return cur.val;
    }
}
