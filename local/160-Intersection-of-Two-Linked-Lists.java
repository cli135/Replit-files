// https://leetcode.com/problems/intersection-of-two-linked-lists/


160. Intersection of Two Linked Lists
Easy

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:

It is guaranteed that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

 

Example 1:

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

Example 2:

Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'
Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.

Example 3:

Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: No intersection
Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.

 

Constraints:

    The number of nodes of listA is in the m.
    The number of nodes of listB is in the n.
    0 <= m, n <= 3 * 104
    1 <= Node.val <= 105
    0 <= skipA <= m
    0 <= skipB <= n
    intersectVal is 0 if listA and listB do not intersect.
    intersectVal == listA[skipA + 1] == listB[skipB + 1] if listA and listB intersect.

 
Follow up: Could you write a solution that runs in O(n) time and use only O(1) memory?


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    final ListNode notYet = new ListNode(); // return flag for 'no intersection found yet'
    // null means intersection is at beyondLast point, a.k.a. separate lists
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // starting at equal points, so they can come back up togehter
        int diff = length(headA) - length(headB);
        if (diff > 0) {
            return getIntersectionNode(headA.next, headB);
        }
        else if (diff < 0) {
            return getIntersectionNode(headA, headB.next);
        }
        // length checking done
        else {
            return findIntersectionNode(headA, headB);
        }
    }
    public ListNode findIntersectionNode(ListNode headA, ListNode headB) {
        // equal lengths now
        
        // base case
        if (headA == null && headB == null) {
            return notYet; // getting us started in the reverse search
        }
        
        // if you want to do postorder / reverse traverse in a nonvoid method,
        // just save the output to a variable then write your going-back-up
        // code afterwards the recursive call (instead of returning
        // the output and immediately extending the solution)
        // you can delay the extending of the solution
        
        // saving
        ListNode intersect = getIntersectionNode(headA.next, headB.next);
        // now going back up and doing analysis
        // recursive case
        // the issue is conflating null in two meanings
        // null 1 - there was no intersection found yet, but there will be
        // null 2 - the 'intersection' was beyondLast, since the lists are separated
        // solution: let null 1 be dummy, and actual null be null 2
        if (intersect != notYet) {
            return intersect; // found intersection later down the list
        }
        // base case: check here, trying to find the discrepancy / intersect point
        else if (headA != headB) {
            return headA.next; // went one beyond
        }
        // base case: no discrepancy found here
        else {
            return notYet; // nothing found, going back up
        }
    }
    public int length(ListNode head) {
        // base case (beginning and end)
        if (head == null) {
            return 0;
        }
        // recursive
        return 1 + length(head.next);
    }
    // previous try's methods
    /*
    public ListNode tailOf(ListNode head) {
        // base case: beginning and end
        if (head == null || head.next == null) {
            return head;
        }
        // recursive case: keep on searching
        return tailOf(head.next);
    }
    public ListNode findIntersectionNode(ListNode headA, ListNode headB) {
        // going down first
        if (headA == null && headB == null) {
            return null; // go back up
        }
        else if (headA == null) {
            // go down B
            findIntersectionNode(headA, headB.next); // act like void
        }
        else if (headB == null) {
            // go down A
            findIntersectionNode(headA.next, headB); // act like void
        }
        else {
            // go down both
            findIntersectionNode(headA.next, headB.next);
        }
        
        
        // this doesn't work because the headA and headB don't
        // come back up the call stack together
        
        
        // on the way back up
        // check not equal
        if (headA != headB) {
            if (headA == null) return headB.next;
            else return headA.next; // went past by 1
        }
        else {
            return null; // keep on going back up
        }
    }
    */
}

// current doesn't work but yeah
