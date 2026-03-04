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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode nodeA = new ListNode();
        ListNode nodeB = new ListNode();
        nodeA.next = head;
        nodeB.next = head;
        ListNode current = head;

        for (int i = 0; i < k - 1; i++) {
            nodeA = nodeA.next;
        }

        ListNode firstNode = nodeA.next;
        nodeA = nodeA.next;

        while (nodeA != null && nodeA.next != null) {
            nodeB = nodeB.next;
            nodeA = nodeA.next;
        }

        ListNode secondNode = nodeB.next;
        
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
        
        return current;
    }
}