/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    let result = 0;
    let len = nums.length;
    for (let i = 0; i < len; i++) {
        result ^= nums[i];
    }
    return result;
};