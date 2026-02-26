class Solution {
    public String validIPAddress(String queryIP) {
        if (isIPv4(queryIP)) return "IPv4";
        if (isIPv6(queryIP)) return "IPv6";
        return "Neither";
    }

    private boolean isIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) return false;

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3) return false;

            // Leading zero check
            if (part.length() > 1 && part.charAt(0) == '0') return false;

            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }

            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) return false;
        }

        return true;
    }

    private boolean isIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        if (parts.length != 8) return false;

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 4) return false;

            for (char c : part.toCharArray()) {
                if (!isHexChar(c)) return false;
            }
        }

        return true;
    }

    private boolean isHexChar(char c) {
        return (c >= '0' && c <= '9') ||
               (c >= 'a' && c <= 'f') ||
               (c >= 'A' && c <= 'F');
    }
}