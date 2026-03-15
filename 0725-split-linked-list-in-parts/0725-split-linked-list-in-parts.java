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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        ListNode[] result = new ListNode[k];
        int size = 0;

        while (curr != null) {
            curr = curr.next;
            size++;
        }
        
        int extraNodes = size % k;
        curr = head;
        ListNode prev = head;
        
        for (int i = 0; i < k; i++) {
            ListNode partHead = curr;
            int partSize = size / k;

            if (extraNodes > 0) {
                extraNodes--;
                partSize++;
            }

            while (partSize > 0 && curr != null) {
                prev = curr;
                curr = curr.next;
                partSize--;
            }

            if (prev != null) {
                prev.next = null;
            }
            result[i] = partHead;
        }
        return result;
    }
}