/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};
*/

class Solution {
    public int[] toArray(Node node) {
        List<Integer> ans = new ArrayList<>();

        while (node.prev != null) {
            node = node.prev;
        }

        while (node != null) {
            ans.add(node.val);
            node = node.next;
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}