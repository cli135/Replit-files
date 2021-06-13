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
    public ListNode mergeKLists(ListNode[] lists) {
        // base case:
        // finding idx of minimum of remaining values in lists
        int minIdx = -1;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < minVal) {
                // dont forget to update minIdx
                // AND minVal
                minVal = lists[i].val;
                minIdx = i;
            }
        }
        if (minIdx == -1) {
            return null; // end of merging process
        }
        
        // recursive case:
        // found minIdx
        ListNode root = lists[minIdx];
        // modify lists now...is this allowed lol
        lists[minIdx] = lists[minIdx].next;
        root.next = mergeKLists(lists);
        return root;
    }
}