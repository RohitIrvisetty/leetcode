class Solution {
    public int largestInteger(int num) {
        char[] arr = String.valueOf(num).toCharArray();

        List<Character> odd = new ArrayList<>();
        List<Character> even = new ArrayList<>();

        for (char c : arr) {
            int d = c - '0';
            if (d % 2 == 0) even.add(c);
            else odd.add(c);
        }        

        odd.sort(Collections.reverseOrder());
        even.sort(Collections.reverseOrder());

        int oi = 0, ei = 0;

        for (int i = 0; i < arr.length; i++) {
            int d = arr[i] - '0';
            if (d % 2 == 0) {
                arr[i] = even.get(ei++);
            } else {
                arr[i] = odd.get(oi++);
            }
        }

        return Integer.parseInt(new String(arr));
    }
}