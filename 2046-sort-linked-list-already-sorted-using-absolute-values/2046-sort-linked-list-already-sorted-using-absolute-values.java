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
    public ListNode sortLinkedList(ListNode head) {
        ListNode front = head;
        ListNode curr = head.next;
        ListNode prev = head;

        while (curr != null) {
            if (curr.val < 0) {
                prev.next = curr.next;
                curr.next = front;
                front = curr;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return front;
    }
}