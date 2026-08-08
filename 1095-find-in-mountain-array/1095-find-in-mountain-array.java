/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peak = partition(mountainArr);
        int leftResult = binarySearchAscending(
            mountainArr, target, 0, peak
        );

        if (leftResult != -1) {
            return leftResult;
        }

        return binarySearchDescending(
            mountainArr, target, peak + 1, n - 1
        );
    }

    private int partition(MountainArray mountainArr) {
        int left = 0, right = mountainArr.length() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int binarySearchAscending(
        MountainArray arr,
        int target,
        int left,
        int right
    ) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = arr.get(mid);

            if (value == target) {
                return mid;
            }

            if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private int binarySearchDescending(
        MountainArray arr,
        int target,
        int left,
        int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = arr.get(mid);

            if (value == target) {
                return mid;
            }

            // Values decrease as index increases.
            if (value < target) {
                // Need a larger value -> move left
                right = mid - 1;
            } else {
                // value > target -> move right
                left = mid + 1;
            }
        }

        return -1;
    }
}