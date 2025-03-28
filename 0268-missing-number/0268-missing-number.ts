function missingNumber(nums: number[]): number {
    let length = nums.length;  
    let targetSum = (length * (length + 1)) / 2;
    let sum = 0;
    nums.forEach(ele => {
        sum += ele;
    });
    return targetSum - sum;
};