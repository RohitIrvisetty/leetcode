class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        arr.sort()
        return sorted(arr, key = lambda a: bin(a)[2:].count('1'))