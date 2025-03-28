class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        min_dist = float("inf")
        ans = sorted(points, key = lambda point: sqrt(point[0] * point[0] + point[1] * point[1]))
        return ans[0: k]