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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int LLlength = 0, counter = 1;
        ListNode curr = head;
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        ListNode prev_subList = dummy;

        while (curr != null) {
            curr = curr.next;
            LLlength++;
        }

        curr = head;
        dummy.next = curr;
        
        while (LLlength > 0) {
            int groupLength = counter;

            if (((counter % 2 == 0) && (LLlength >= counter)) || ((LLlength < counter) && (LLlength % 2 == 0))) {
                while (groupLength > 0 && curr != null) {

                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                    groupLength--;

                }
                prev_subList.next.next = curr;
                ListNode nextPrev = prev_subList.next;
                prev_subList.next = prev;
                prev_subList = nextPrev;
                prev = prev_subList;

            } else {
                while (groupLength > 0 && curr != null) {

                    curr = curr.next;
                    prev = prev.next;
                    groupLength--;

                }
                prev_subList = prev;
            }

            LLlength -= counter;
            counter++;
        }

        return dummy.next;
    }
}