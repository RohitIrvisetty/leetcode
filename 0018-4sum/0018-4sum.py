class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        ans = []
        for i in range(n):
            if i>0 and nums[i]==nums[i-1]:
                continue
            for j in range(i+1,n):
                if j!=i+1 and nums[j]==nums[j-1]:
                    continue
                new_val = target - (nums[i]+nums[j])
                l,r = j+1, n-1
                while l<r:
                    temp_sum = nums[l]+nums[r]
                    if temp_sum <new_val:
                        l+=1
                    elif temp_sum >new_val:
                        r-=1
                    else:
                        print(i,j,l,r)
                        ans.append([nums[i], nums[j], nums[l],nums[r]])
                        l+=1
                        r-=1
                        while(l<r and nums[l]==nums[l-1]):
                            l+=1
                        while(l<r and nums[r]==nums[r+1]):
                            r-=1
        return ans