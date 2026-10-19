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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode curr = head;

        while (curr != null) {

            for (int i = 0; i < m - 1; i++) {
                if (curr == null) {
                    return head;
                }

                curr = curr.next;
            }

            ListNode prev = curr;
            //prev.next = null;

            if (curr == null) {
                return head;
            }
            curr = curr.next;

            for (int j = 0; j < n; j++) {
                if (curr == null) {
                    prev.next = null;
                    return head;
                }

                curr = curr.next;
            }

            prev.next = curr;
        }

        return head;
    }
}