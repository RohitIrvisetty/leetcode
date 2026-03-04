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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenList = new ListNode();
        ListNode oddList = new ListNode();
        ListNode evenHead = evenList;
        ListNode oddHead = oddList;
        ListNode dummy = head;
        int index = 0;

        while (dummy != null) {
            ListNode next = dummy.next;
            dummy.next = null;
            if (index % 2 == 0) {
                evenHead.next = dummy;
                evenHead = evenHead.next;
            } else {
                oddHead.next = dummy;
                oddHead = oddHead.next;
            }
            index++;
            dummy = next;
        }
        evenHead.next = oddList.next;
        return evenList.next;
        
        
    }
}