/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // base case:
        if (head == null) {
            // beginning or end
            // no cycles starting here
            return false;
        }
        // any cycles here or later? if any, return true!
        return isCycle(head, head.next) || hasCycle(head.next);
    }
    private boolean isCycle(ListNode node, ListNode runner) {
        // head is guaranteed to not be null in hasCycle
        // gotta check runner
        if (runner == null) {
            // no cycle here (starting at node)
            return false;
        }
        // found a cycle!!
        if (node == runner) {
            return true;
        }
        // otherwise, keep on checking further down the line
        // send runner farther
        return isCycle(node, runner.next);
    }
}