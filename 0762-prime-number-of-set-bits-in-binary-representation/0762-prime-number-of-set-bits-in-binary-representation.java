
class Solution {
    private int isPrime(int num) {
        //if ((num % 2) == 0 || (num % 3) == 0) return 0;


        // for(int i = 5; i * i < num; i += 6) {
        //     if ((num % i) == 0 || (num % (i + 2)) == 0) {
        //         return 0;
        //     }
        // }

        switch (num) {
            case 2, 3, 5, 7, 11, 13, 17, 19:
            return 1;

            default: 
            return 0;


        }

        //return 0;
    }

    private int countSetBits(int num) {
        int ans = 0;
        while(num > 0) {

            if ((num & 1) > 0) {
                ans++;
            }
            num = num >> 1;
        }
        return ans;
    }

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int setBits = countSetBits(i);
            System.out.print(setBits);
            ans += isPrime(setBits);
        }
        return ans;
    }
}