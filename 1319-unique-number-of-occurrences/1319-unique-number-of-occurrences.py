from collections import Counter
class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        counter = Counter(arr)
        uniqueSet=set(counter.values())
        return (len(uniqueSet)==len(counter.values()))