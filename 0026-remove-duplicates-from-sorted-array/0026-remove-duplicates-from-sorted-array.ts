function removeDuplicates(nums: number[]) {
    let currentNode = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] != nums[currentNode]) {
            currentNode++;
            nums[currentNode] = nums[i];
        }
    }
    return currentNode + 1;
};