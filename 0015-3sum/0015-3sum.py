class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res, dup = set(), set()
        obj = {}
        for i1, j1 in enumerate(nums):
            if j1 not in dup:
                dup.add(j1)
                obj={}
                for i2, j2 in enumerate(nums[i1 + 1:]):
                    complement = -j1 - j2
                    if complement in obj:
                        res.add(tuple(sorted((j1, j2, complement))))
                    obj[j2] = i1
        return res
                    
