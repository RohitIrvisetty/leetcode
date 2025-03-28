function removeElement(nums: number[], val: number): number {
    let currentIndex = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
            nums[currentIndex] = nums[i];
            currentIndex++;
        }
    }
    return currentIndex;
};