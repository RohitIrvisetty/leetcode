class Solution {
    public ListNode[] splitCircularLinkedList(ListNode list) {
        ListNode slow = list;
        ListNode fast = list;
        
        while (fast.next != list && fast.next.next != list) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head1 = list;
        ListNode head2 = slow.next;

        if (fast.next == list) {
            fast.next = head2;
            slow.next = head1;
        } else if (fast.next.next == list) {
            fast.next.next = head2;
            slow.next = head1;
        }

        return new ListNode[] {head1, head2};
    }
}
