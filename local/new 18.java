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
class Solution {
    // lesson learned:
    // when you're asked to splice nodes together,
    // you ***don't*** / hopefully shouldn't need to create new nodes!!!
    // you can just do funcitonal and rearrange links.
    // Thanks to Whittaker Brand for teaching me
    // kinda functional programming.
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // base case (beginning and ending)
        // learned from yangliguang at
        // https://leetcode.com/problems/merge-two-sorted-lists/discuss/9715/Java-1-ms-4-lines-codes-using-recursion
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // ^ this way it covers both AND and XOR
        // for null base cases (both beginning and end),
        // look to avoid the
        // if && return
        // if || return
        // construct. Instead try this:
        // yangliguang's method
        // if 1 null then return 2
        // if 2 null then return 1
        
        // recursive case: both are nonempty
        if (l1.val <= l2.val) {
            // l1 is the root, and its .next is the rest merged
            // Java evalutes rhs before lhs yay
            l1.next = mergeTwoLists(l1.next, l2);   
            return l1;
        }
        else {
            // l2 is the root, and the .next is the rest merged
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}