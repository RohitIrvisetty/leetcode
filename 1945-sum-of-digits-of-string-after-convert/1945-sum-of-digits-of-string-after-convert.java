class Solution {
    public int getLucky(String s, int k) {
        String transformation;
        StringBuilder asciiValues = new StringBuilder();
        
        for (char ch: s.toCharArray()) {
            asciiValues.append((ch - 97) + 1);
        }

        transformation = asciiValues.toString();

        for (int i = 0; i < k; i++) {
            transformation = transform(transformation);
        }

        return Integer.parseInt(transformation);
    }

    private String transform(String s) {
        int summation = 0;
        
        for (char ch: s.toCharArray()) {
            summation += ch - '0';
        }

        return String.valueOf(summation);
    }
}