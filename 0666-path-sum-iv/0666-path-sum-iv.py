from typing import List

class Solution:
    def pathSum(self, nums: List[int]) -> int:
        # Build a map: heap-like index -> value
        # Encoded num = D P V  (D: depth 1..4, P: position 1..8, V: value)
        nodes = {}
        for x in nums:
            d = x // 100
            p = (x // 10) % 10
            v = x % 10
            idx = (1 << (d - 1)) + (p - 1)   # root index = 1
            nodes[idx] = v

        ans = 0

        def dfs(i: int, running: int) -> None:
            nonlocal ans
            if i not in nodes:
                return
            running += nodes[i]
            left, right = i * 2, i * 2 + 1
            # leaf: both children absent
            if left not in nodes and right not in nodes:
                ans += running
                return
            dfs(left, running)
            dfs(right, running)

        dfs(1, 0)  # start at root (index 1)
        return ans
