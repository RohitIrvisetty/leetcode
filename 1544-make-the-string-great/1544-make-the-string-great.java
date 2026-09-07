class Solution {
    public String makeGood(String s) {
        char[] arr = s.toCharArray();

        int top = 0;

        for (char c : arr) {
            if (top > 0 &&
                Character.toLowerCase(arr[top - 1]) == Character.toLowerCase(c) &&
                arr[top - 1] != c) {

                top--;  // Remove the top character
            } else {
                arr[top++] = c;  // Push character
            }
        }

        return new String(arr, 0, top);
    }
}