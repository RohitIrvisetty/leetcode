class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        ans=[[None]*len(matrix) for x in range(len(matrix[0]))]
        for num, id in enumerate(matrix):
            for num1, id1 in enumerate(id):
                ans[num1][num]=id1
        return ans

