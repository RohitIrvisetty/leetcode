/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node curr = new Node(insertVal);
            curr.next = curr;
            return curr;
        }

        if (head.next == head) {
            Node newNode = new Node(insertVal, head);
            head.next = newNode;
            return head;
        }

        Node curr = head.next;
        Node prev = head;

        do {
            if (curr.val >= insertVal && prev.val <= insertVal) {
                insertNewNode(curr, prev, insertVal);
                return head;
            } else if (prev.val > curr.val) {
                if (prev.val <= insertVal || curr.val >= insertVal) {
                    insertNewNode(curr, prev, insertVal);
                    return head;
                }
            }
            prev = curr;
            curr = curr.next;
        } while (prev != head);

        prev.next = new Node(insertVal, curr);
        return head;
    }

    private void insertNewNode(Node curr, Node prev, int insertVal) {
        Node newNode = new Node(insertVal, curr);
        prev.next = newNode;
        return;
    }
}