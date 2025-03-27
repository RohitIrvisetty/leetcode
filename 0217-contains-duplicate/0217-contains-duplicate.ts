function containsDuplicate(nums: number[]): boolean {
    let distinctArray: number[] = [...new Set(nums)];
    return distinctArray.length < nums.length;
};