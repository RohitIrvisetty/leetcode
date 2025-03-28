class Solution:
    def groupAnagrams(self, strs):
        ans=collections.defaultdict(list)
        for s in strs:
            hashkey = [0] * 26
            for c in s:
                hashkey[ord(c) - ord('a')]+=1
            ans[tuple(hashkey)].append(s)
        return ans.values()