class Solution {
    private int numOfSetBits(int num) {
        int count = 0;
        while (num > 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }


    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = (i & 1) + ans[i>>1];
        }

        return ans;
    }

    // O(n * logn)
    // O(n)


    // i   
    // 0 -> 0
    // 1 -> {
    //     last bit: 1 & 1 -> 1
    //     remaining bits 1 >> 1 -> 0

    //     1 + 0 = 1

    // 2 -> {
    //     last bit: 2(10) & 1(01) -> 0
    //     remaining bits 10 >> 1 -> 1

    //         ans[i] = (i & 1) + ans[i>>1];
    //                 = 0 + 1
    //                 1

    //         i >> 1 => i / 2
    // }
    
}