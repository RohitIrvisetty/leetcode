class Solution {
    public void reverseWords(char[] s) {
        int n = s.length;
        int left = 0, right = n - 1;

        while (left < right) {
            swap(s, left++, right--);
        }

        left = 0;

        for (int i = 0; i < n; i++) {
            if (s[i] == ' ') {
                reverse(s, left, i - 1);
                left = i + 1;
            } else if (i == n - 1) {
                reverse(s, left, i);
            }
        }
    }

    private void swap(char[] s, int left, int right) {
        if (left != right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            swap(s, left++, right--);
        }
    }
}