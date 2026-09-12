class Solution {
    public String simplifyPath(String path) {
        // Initialize a stack
        Deque<String> stack = new ArrayDeque<String>();
        String[] components = path.split("/");

        for (String directory : components) {
            if (directory.equals(".") || directory.equals("")) {
                continue;
            } else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(directory);
            }
        }

        // Stich together all the directory names together
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/");
            result.append(stack.removeLast());
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}