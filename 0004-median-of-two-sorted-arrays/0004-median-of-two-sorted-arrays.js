/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    let mergedArray = nums1.concat(nums2).sort((a, b) => a - b);
    let isMergedArrayEven = ((mergedArray.length % 2) == 0);
    if (isMergedArrayEven) {
        return (mergedArray[mergedArray.length / 2] + mergedArray[(mergedArray.length / 2) - 1]) / 2;
    }
    console.log(mergedArray);
    return mergedArray[Math.floor(mergedArray.length / 2)];
};