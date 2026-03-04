class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] hexMap = "0123456789abcdef".toCharArray();
        int mask = 0xf;
        StringBuilder ans = new StringBuilder();
        
        while (num != 0) {
            int last4Bits = num & mask;
            ans.append(hexMap[last4Bits]);
            num >>>= 4;
        }

        return ans.reverse().toString();
    }
}