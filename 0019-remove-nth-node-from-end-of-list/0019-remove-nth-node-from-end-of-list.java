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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode nodeA = dummy;
        ListNode nodeB = dummy;
        //nodeA.next = head;
        //nodeB.next = head;
        
        for (int i = 0; i < n; i++) {
            nodeB = nodeB.next;
        }

        
        while (nodeB.next != null) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        
        nodeA.next = nodeA.next.next;
        return dummy.next;
    }
}