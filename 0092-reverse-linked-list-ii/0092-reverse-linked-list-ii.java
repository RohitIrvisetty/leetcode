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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        prev.next = head;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode prevSubList = prev;
        ListNode leftNode = prevSubList.next;

        for (int i = 0; i < (right -left); i++) {
            prev = prev.next;
        }

        ListNode rightNode = prev.next;
        ListNode afterSubList = rightNode.next;

        prevSubList.next = null;
        rightNode.next = null;

        ListNode curr = leftNode;
        prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        prevSubList.next = rightNode;
        leftNode.next = afterSubList;

        return dummy.next;
    }
}