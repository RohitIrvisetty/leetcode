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

function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
    let output = new ListNode(0);
    let currentNode = output;
    let carry = 0;
    while (l1 || l2) {
        let sum = (l1 ? l1.val : 0) + (l2 ? l2.val : 0) + carry;
        carry = sum > 9 ? 1 : 0;
        currentNode.next = new ListNode(sum%10);
        currentNode = currentNode.next;
        l1 = l1 ? l1.next : null;
        l2 = l2 ? l2.next : null;
    }
    if (carry) currentNode.next = new ListNode(carry)
    return output.next;
};