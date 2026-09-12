/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int top = 0, bottom = n - 1;

        while (top < bottom) {
            if (knows(top, bottom)) {
                top++;
            } else if (knows(bottom, top)) {
                bottom--;
            } else {
                top++;
                bottom--;
            }
        }

        for (int i = 0; i < n; i++) {
            if (top == i) {
                continue;
            }
            if (knows(top, i) || !knows(i, top)) {
                return -1;
            }
        }
        return top;
    }
}