function singleNumber(nums: number[]): number {
    let nums_sum: number = nums.reduce((acc, curr) => acc + curr, 0);
    let set_sum: number = [...new Set(nums)].reduce((acc, curr) => acc + curr, 0);
    return ((3 * set_sum) - nums_sum) / 2;
};