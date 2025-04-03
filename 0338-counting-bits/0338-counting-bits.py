class Solution:
    def countBits(self, n: int) -> List[int]:
        def hamming_weight(x):
            count = 0
            while x:
                x &= (x - 1)
                count += 1
            return count

        return [hamming_weight(i) for i in range(n + 1)]
        