/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while ((nodeA != nodeB)) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
            if (nodeA == null) {
                nodeA = headB;
                headB = null;
            }
            if (nodeB == null) {
                nodeB = headA;
                headA = null;
            }
        }

        return nodeA;
        
    }
}