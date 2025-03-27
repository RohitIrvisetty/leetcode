class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        result = []
        elem1, elem2 = 0, 0
        count1, count2 = 0, 0
        n = len(nums)

        for i in range(n): 
            if nums[i] == elem1:
                count1 += 1
            elif nums[i] == elem2:
                count2 += 1
            elif count1 == 0:
                elem1, count1 = nums[i], 1
            elif count2 == 0:
                elem2, count2 = nums[i], 1
            else:
                count1 -= 1
                count2 -= 1
        print(elem1, elem2)
        if nums.count(elem1) > (n // 3):
            result.append(elem1)
        if elem2 is not None and elem1 != elem2 and nums.count(elem2) > (n // 3):
            result.append(elem2)
        return result