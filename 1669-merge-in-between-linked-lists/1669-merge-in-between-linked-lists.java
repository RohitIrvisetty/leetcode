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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = list1;
        ListNode curr = list1.next;

        while (a > 1) {
            a--;
            b--;
            prev = curr;
            curr = curr.next;
        }

        while (b > 0) {
            b--;
            curr = curr.next;
        }

        prev.next = list2;

        while (prev.next != null) {
            prev = prev.next;
        }

        prev.next = curr;

        return list1;
    }
}