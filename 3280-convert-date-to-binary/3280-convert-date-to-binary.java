class Solution {
    private String binary(int num) {
        StringBuilder ans = new StringBuilder();

        while (num > 0) {
            int remainder = num % 2;
            ans.append(remainder);
            num = num / 2;
        }

        return ans.reverse().toString();
    }

    public String convertDateToBinary(String date) {
        String[] parts = date.split("-");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        return binary(year) + '-' + binary(month) + '-' + binary(day);
    }
}