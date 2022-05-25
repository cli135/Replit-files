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
        // note 5-25-2022: if this works this is really neat
        
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
    
    // below 4 methods are from 5-25-2022
    public ListNode reverseList(ListNode head) {
        
        return reverseLinkedListCool(head);
        // return reverseLinkedListRecursively(null, head);
        // return reverseLinkedListIteratively(head);
    }
    /**
    
    Recursively reverses a linked list, but with a different (possibly
    better) approach than the one below: instead of going by 2s front-to-back
    and deferring finding the true head until the end, (the 2s cause a
    even-odd difference in the base case, and it turns out that front-to-back
    requires a prev pointer to link up the back part),
    
    instead of the above, we acutally go straightaway to the back of the list
    and get the true head. then we go back up the call stack (since we
    recursed to the bottom of the call stack staircase right away),
    keeping track of the true head, and using the previous forward links
    as a quick backdoor into the tail of the reversed part. in this way
    we can get the head first (by 1s), and then proceed backwards one at a
    time, using the previously existing forward links to access the tail
    and append to the reversed list.
    
    This is actually quite different from the below approach in multiple ways:
    
    -1s vs 2s
    
    -back to front vs. front to back
    
    -get new head first and bring it to the front vs. defer head to last and use it as motivation to proceed thru list
    
    -front end (right away) recursion vs. tail-end recursion
    
    -already existing forward links backdoor into tail of reversed vs. prev
    
    
    These two approaches are *not* "mirror" images of each other
    because the linked list itself is not symmetric
    and the links only go one way. it just seems like they are mirrors
    based off the direction they travel in, but the no prev and prev difference
    shows they are not just mirrors, imo, unless previous forward links
    are prevs too?
    */
    public ListNode reverseLinkedListCool(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head; // what about the odd and even cases
        }
        // well in this case we aren't jumping by 2s or 3s or etc
        // we are jumping by ones
        // so the 0 case will only happen at the beginning
        // and the 1 case will only happen at the end
        // that is convenient compared to jumping by 2s / 3s
        // then 0 case happens on even length lists
        // and 1 case happens on odd length lists due to parity
        
        // recursive case: relies on knowing the answer to
        // the subproblem: reversed remaining list
        // (front end recursion, go to bottom of stack
        // and work our way back up)
        ListNode remainingReversed = reverseLinkedListCool(head.next);
        // here's the cool part: head.next *link* didn't change
        // so we have a secret backdoor access to the tail node
        // of the reversed part
        ListNode tailReversedPart = head.next;
        tailReversedPart.next = head; // linking up 2 to 1
        // 1 needs to point to null otherwise we'll have a 6-7 cycle
        // or a 1-2 cycle
        head.next = null;
        return remainingReversed; // the new head
    }
    
    /**
    Reverses a linked list recursively, going front to back.
    Returning the new head is deferred to the end, which is a way
    to get the list to proceed through the whole list (making modifications
    as side effects) until it gets to the end and can return the head.
    */
    public ListNode reverseLinkedListRecursively(ListNode prev, ListNode head) {
        // 0 or 1 nodes, base case
        if (head == null) {
            return prev; // 0 case (not only at the beginning, but an even length linked list ends this way)   
        }
        if (head.next == null) { // 1 case at the end (odd length linked lists end this way)
            head.next = prev; // link up that last link (parity difference between even and odd)
            return head; // return the head
        }
        // 2+ nodes, recursive case
        ListNode third = head.next.next; // save third
        head.next.next = head; // make second point to first
        ListNode second = head.next; // save second
        head.next = prev; // make first point to zeroth
        // make prev become second
        // make head become third
        
        // what we return gets continually deferred until we get
        // to the true end of the linked list and we return the new head
        // which was the original tail
        return reverseLinkedListRecursively(second, third);
        // this is tail end recursion
    }
    /**
    Reverses a linked list iteratively.
    */
    public ListNode reverseLinkedListIteratively(ListNode head) {
        if (head == null || head.next == null) {
            return head; // done, only one element
        }
        
        //ListNode dummy = new ListNode(0, head);
        
        // saving the third
        ListNode temp = head.next.next;
        // the previous node, kind of like global variable
        ListNode prev = null;
        while (head != null && head.next != null) {
            
            // save 3
            temp = head.next.next;
            
            // null <- 1 <- 2
            head.next.next = head;
            ListNode mid = head.next; // save 2
            head.next = prev;
            
            // save 2 as prev            
            prev = mid;
            
            // 3 is now head
            head = temp;
        }
        // even case ending
        if (head == null) {
            head = prev;
        }
        // odd case ending
        else {
            head.next = prev;
        }
        // return the new head;
        return head;
        
    }
}
