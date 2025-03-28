class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        output=0
        while True:
            nums=[i for i in nums if i!=0]
            if len(nums)==0:
                break
            x=min(nums)
            nums=[i-x for i in nums]
            output+=1
        return output
        