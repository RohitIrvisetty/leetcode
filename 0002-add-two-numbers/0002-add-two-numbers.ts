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
    let firstArr: ListNode | null;
    let secondArr: ListNode | null;
    let output: ListNode = new ListNode(0);
    let now = output;
    //console.log(output);
    let carry: number = 0;
    console.log("1", l1.next);
    while (l1 != null || l2 != null) {
        let sum: number = (l1 ? l1.val : 0) + (l2 ? l2.val : 0) + carry;
        now.next = new ListNode(sum % 10);
        now = now.next;
        carry = sum > 9 ? 1 : 0;
        l1 = l1 ? l1.next : null;
        l2 = l2 ? l2.next : null;
    }
    if (carry) now.next = new ListNode(carry);
    console.log(output);
    console.log(now);
    return output.next;
};