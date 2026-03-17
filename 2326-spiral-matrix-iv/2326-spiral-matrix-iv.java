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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];

        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;
        ListNode curr = head;

        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                int nodeVal = (curr != null) ? curr.val : -1;
                ans[top][i] = nodeVal;
                curr = (curr != null) ? curr.next : null;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                int nodeVal = (curr != null) ? curr.val : -1;
                ans[i][right] = nodeVal;
                curr = (curr != null) ? curr.next : null;

            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    int nodeVal = (curr != null) ? curr.val : -1;
                    ans[bottom][i] = nodeVal;
                    curr = (curr != null) ? curr.next : null;

                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    int nodeVal = (curr != null) ? curr.val : -1;
                    ans[i][left] = nodeVal;
                    curr = (curr != null) ? curr.next : null;

                }
                left++;
            }
        }
        return ans;
    }
}