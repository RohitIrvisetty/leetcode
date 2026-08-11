class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;
        double left = 0;
        double right = 0;

        for (int i = 1; i < n; i++) {
            right = Math.max(right, stations[i] - stations[i - 1]);
        }  

        while (right - left > 1e-6) {
            double mid = left + (right - left) / 2;

            int newStations = placeNewStations(stations, mid, k);

            if (newStations <= k) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private int placeNewStations(int[] stations, double dist, int k) {
        int n = stations.length;
        int count = 0;

        for (int i = 1; i < n; i++) {
            //count += (stations[i] - stations[i - 1]) / dist;

            double gap = stations[i] - stations[i - 1];
            count += (int) Math.ceil(gap / dist) - 1;
        }

        return count;
    }
}