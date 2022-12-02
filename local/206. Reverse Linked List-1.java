// updated 11-15-2022 approx 

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
        ListNode cur = head;
        // using cur as a way to traverse
        // and modify the list from front to back
        // like doing a short operation in each short interval
        
        // going to traverse and modify as it goes
        
        // look ahead, look before we leap, to change links *early*
        // otherwise we'll be too late to arrive on the spot
        ListNode prev = null;
        while (cur != null) {
            
            // reverse this portion in constant time (inside loop)
            
            // saving 2
            ListNode temp = cur.next;
            // making 1 point to null
            cur.next = prev;
            
            prev = cur; // new prev
            cur = temp; // advance to next original node (2)
        }
        
        // cur actually went beyond
        return prev;
    }
}
