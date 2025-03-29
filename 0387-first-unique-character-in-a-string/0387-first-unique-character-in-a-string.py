class Solution:
    def firstUniqChar(self, s: str) -> int:
        self.hashMap=Counter(s)
        for idx, ch in enumerate(s):
            if self.hashMap[ch] == 1:
                return idx     
        return -1