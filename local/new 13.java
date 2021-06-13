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
    public ListNode reverseKGroup(ListNode head, int k) {
        // base case; head is guaranteed to be non null
        // end of list
        if (head.next == null) {
            return head;
        }
        // base case another, end of k-group
        if (k == 1) {
            // go reverse deeper while we're here
            head.next = reverseKGroup(head.next, k);
            
        }  
        // recursive case
        head.next = reverseKGroup(head.next, k - 1);
    }
    private ListNode reverseKGroup(ListNode head, int k, ListNode localHead) {
        ;
    }
}