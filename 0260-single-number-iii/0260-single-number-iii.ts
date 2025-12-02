function singleNumber(nums: number[]): number[] {
    let xorVallue: number = 0;
    for (let i = 0; i < nums.length; i++) {
        xorVallue ^= nums[i];
    }
    let a, b = 0;
    let d = xorVallue & -xorVallue;
    for (let i = 0; i < nums.length; i++) {
        if (d & nums[i]) {
            a ^= nums[i];
        } else {
            b ^= nums[i];
        }
    }
    return [a, b];
};
