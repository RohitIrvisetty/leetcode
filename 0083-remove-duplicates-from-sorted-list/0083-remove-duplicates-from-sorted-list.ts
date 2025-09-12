/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function deleteDuplicates(head: ListNode | null): ListNode | null {
    let output = head;
    while (output) {
        if (output.val === output.next?.val) {
            output.next = output.next.next;
        } else {
            output = output.next; 
        }
    }
    return head;
};