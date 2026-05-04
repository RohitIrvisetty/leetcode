class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        StringBuilder updatedString = new StringBuilder();

        if (n % 2 != 0) return false;

        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                updatedString.append('*');
            } else {
                updatedString.append(s.charAt(i));
            }
        }

        System.out.println(updatedString.toString());
        Stack<Integer> starStack = new Stack<>();
        Stack<Integer> openStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (updatedString.charAt(i) == '(') {
                openStack.push(i);
            } else if (updatedString.charAt(i) == '*') {
                starStack.push(i);
            } else {
                if (openStack.size() > 0) {
                    openStack.pop();
                } else if (starStack.size() > 0) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        while (!openStack.isEmpty() && !starStack.isEmpty() && openStack.peek() < starStack.peek()) {
            openStack.pop();
            starStack.pop();
        }
        return openStack.isEmpty() && (starStack.size() % 2 == 0);
    }
}