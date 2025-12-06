class Solution:
    def grayCode(self, n: int):
        result = [0]
        # there are 2 ^ n numbers in the Gray code sequence.
        for i in range (1, n+1):
            prev = len(result)
            mask = 1 << (i - 1)
            for j in range(prev - 1, -1, -1):
                result.append(mask + result[j])
        return result
        