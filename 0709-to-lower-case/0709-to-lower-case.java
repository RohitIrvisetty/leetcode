class Solution {
    public String toLowerCase(String s) {
        StringBuilder lowerCase = new StringBuilder();

        for (Character ch: s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                lowerCase.append(Character.toLowerCase(ch));
            } else {
                lowerCase.append(ch);
            }
        }
        return lowerCase.toString();
    }
}