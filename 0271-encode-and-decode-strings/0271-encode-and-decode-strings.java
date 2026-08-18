class Codec {

    private static final int LENGTH_SIZE = 4;

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            encoded.append(String.format("%04d", str.length()));
            encoded.append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {

            // Read the 4-character length
            int len = Integer.parseInt(
                s.substring(i, i + LENGTH_SIZE)
            );

            i += LENGTH_SIZE;

            // Read exactly 'len' characters
            result.add(s.substring(i, i + len));

            i += len;
        }

        return result;
    }
}