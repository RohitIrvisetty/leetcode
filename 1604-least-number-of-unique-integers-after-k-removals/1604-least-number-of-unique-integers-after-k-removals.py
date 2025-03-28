class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        c = Counter(arr)
        print(c)
        s = sorted(arr,key = lambda x:(c[x], x))
        print(c)
        return len(set(s[k:]))