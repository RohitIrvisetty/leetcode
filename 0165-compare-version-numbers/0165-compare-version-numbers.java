class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Delimitted = version1.split("\\.");
        String[] version2Delimitted = version2.split("\\.");

        int pointer1 = 0, pointer2 = 0;
        int version1Length = version1Delimitted.length;
        int version2Length = version2Delimitted.length;

        System.out.println(Arrays.toString(version1Delimitted));

        while (pointer1 < version1Length || pointer2 < version2Length) {
            int currVersion1, currVersion2;

            if (pointer1 < version1Length) {
                currVersion1 = Integer.parseInt(version1Delimitted[pointer1]);
            } else {
                currVersion1 = 0;
            }
            
            if (pointer2 < version2Length) {
                currVersion2 = Integer.parseInt(version2Delimitted[pointer2]);
            } else {
                currVersion2 = 0;
            }

            
            if (currVersion1 < currVersion2) {
                return -1;
            } else if (currVersion1 > currVersion2) {
                return 1;
            }

            pointer1++;
            pointer2++;
        }
        return 0;
    }
}