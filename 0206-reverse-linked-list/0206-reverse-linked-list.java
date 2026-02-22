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
    private ListNode linkedListHelper(ListNode head, ListNode prev) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        if(next == null) {
            return head;
        }
        head = next;
        return linkedListHelper(head, prev);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        return linkedListHelper(head, null);
    }

}