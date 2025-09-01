class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        hash_map = Counter(nums1)
        answer = []
        for i in nums2:
            if hash_map[i] > 0:
                hash_map[i] -= 1
                answer.append(i)
        return answer