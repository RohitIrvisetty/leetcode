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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode current = head;
        
        ListNode prev_subList = dummy;
        ListNode prev = dummy;
        int length = 0;

        while (current != null) {
            length++;
            current = current.next;
        }

        current = head;
        dummy.next = current;
        
        for (int i = 0; i < length / k; i++) {
            int counter = k;
            prev = prev_subList;
            
            while (counter > 0) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                counter--;
            }

            prev_subList.next.next = current;
            ListNode nextPrev = prev_subList.next;
            prev_subList.next = prev;
            prev_subList = nextPrev;
        }
        return dummy.next;
    }
}