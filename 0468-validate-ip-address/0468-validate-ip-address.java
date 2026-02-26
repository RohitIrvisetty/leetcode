class Solution {
    public String validIPAddress(String queryIP) {
        String ipv4 = 
        "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}" +
        "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";

        String ipv6 = 
        "([0-9a-fA-F]{1,4}:){7}" + "[0-9a-fA-F]{1,4}";

        if (queryIP.matches(ipv4)) return "IPv4";
        if (queryIP.matches(ipv6)) return "IPv6";
        return "Neither";
    }
}