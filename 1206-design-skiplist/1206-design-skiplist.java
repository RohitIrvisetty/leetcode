
import java.util.Random;

class Skiplist {

    private static final int MAX_LEVEL = 16;

    class Node {
        int val;
        Node[] next;

        Node(int val, int level) {
            this.val = val;
            next = new Node[level];
        }
    }

    private Node head;
    private Random random;

    public Skiplist() {
        head = new Node(-1, MAX_LEVEL);
        random = new Random();
    }

    private int randomLevel() {
        int level = 0;

        while (level < MAX_LEVEL &&
               random.nextBoolean()) {
            level++;
        }

        return level;
    }

    public boolean search(int target) {
        Node curr = head;

        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (curr.next[i] != null &&
                   curr.next[i].val < target) {
                curr = curr.next[i];
            }
        }

        curr = curr.next[0];

        return curr != null && curr.val == target;
    }

    public void add(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node curr = head;

        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (curr.next[i] != null &&
                   curr.next[i].val < num) {
                curr = curr.next[i];
            }

            update[i] = curr;
        }

        int level = randomLevel();
        Node newNode = new Node(num, level + 1);

        for (int i = 0; i <= level; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }

    public boolean erase(int num) {
        Node curr = head;
        Node[] update = new Node[MAX_LEVEL];

        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].val < num) {
                curr = curr.next[i];
            }

            update[i] = curr;
        } 

        Node target = update[0].next[0];

        if (target == null || target.val != num) {
            return false;
        }

        int levels = target.next.length;

        for (int i = 0; i < levels; i++) {
            update[i].next[i] = target.next[i];
        }
        return true;
    }
}
