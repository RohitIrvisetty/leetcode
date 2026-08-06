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
    public ListNode plusOne(ListNode head) {
        int carry = helper(head);
        if (carry != 0) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    private int helper(ListNode head) {
        if (head.next == null) {
            int carry = (head.val + 1) / 10;
            head.val = (head.val + 1) % 10;
            return carry;
        }

        int carry = helper(head.next);
        int forwardCarry = (head.val + carry) / 10;
        head.val = (head.val + carry) % 10;
        return forwardCarry;
    }
}