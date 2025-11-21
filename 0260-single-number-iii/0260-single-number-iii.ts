function singleNumber(nums: number[]): number[] {
    return nums.filter((x) => nums.indexOf(x) == nums.lastIndexOf(x)); 
};
