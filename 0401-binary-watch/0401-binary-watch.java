class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        int[] values = new int[] {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
        backtrack(0, 0, 0, turnedOn, values, ans);
        return ans;
    }

    private void backtrack(int index, int hours, int minutes, int turnedOn, int[] values, List<String> ans) {
        
        if (hours > 11 || minutes > 59) {
            return;
        }

        if (turnedOn == 0) {
            ans.add(hours + ":" + String.format("%02d", minutes));
            return;
        }

        if (index == 10) {
            return;
        }

        backtrack(index + 1, hours, minutes, turnedOn, values, ans);

        if (index < 4) {
            backtrack(index + 1, hours + values[index], minutes, turnedOn - 1, values, ans);
        } else {
            backtrack(index + 1, hours, minutes + values[index], turnedOn - 1, values, ans);
        }
    }
}