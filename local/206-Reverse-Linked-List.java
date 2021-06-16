// https://leetcode.com/problems/reverse-linked-list/

206. Reverse Linked List
Easy

Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:

Input: head = [1,2]
Output: [2,1]

Example 3:

Input: head = []
Output: []

 

Constraints:

    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000

 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both

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
    public ListNode reverseList(ListNode head) {
        // return reverseList1(head);
        //return reverseList2(head);
        return reverseListIterative(head);
    }
    public ListNode reverseListIterative(ListNode head) {
        // two runners
        // from the solution -- look locally, not over the whole list
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
    public ListNode reverseList2(ListNode head) {
        
        // from solution
        if (head == null || head.next == null) {
            return head;
        }
        // relies on assuming you know the answer to the subproblem
        ListNode ptr = reverseList(head.next);
        // old links still preserved, so use them to fix things
        head.next.next = head;
        head.next = null;
        return ptr;
        
    }
    public ListNode reverseList1(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // recursive case:
        // go to end of reversed and tack on first
        
        // save first
        ListNode temp = head;
        // reverse the rest, and call it head
        // act like method is already completed
        head = reverseList(head.next);
        // go to end of reversed rest
        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        // tack on first
        ptr.next = temp;
        // break cycle
        temp.next = null;
        // give back the new head
        return head;
    }
}
