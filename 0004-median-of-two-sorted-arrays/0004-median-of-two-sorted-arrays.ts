function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
    let concatArray: number[] = nums1.concat(nums2).sort((a,b) => a-b);
    let medianIndex: number = (concatArray.length)/2;
    return concatArray.length%2 != 0 ? concatArray[Math.floor(medianIndex)] : (concatArray[medianIndex] + concatArray[medianIndex - 1])/2;
};