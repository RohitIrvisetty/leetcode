class Solution:
    def search(self, arr, k):
        n = len(arr)  # size of the array
        left, right = 0, n - 1

        while left <= right:
            mid = (left + right) // 2

            # if mid points to the target
            if arr[mid] == k:
                return True

            if arr[mid] == arr[left] and arr[mid] == arr[right]:
                left += 1
                right -= 1
                continue
            
            if arr[mid] >= arr[left]:
                if k >= arr[left] and k <= arr[mid]:
                    right = mid
                else:
                    left = mid + 1
            else:
                if k >= arr[mid] and k <= arr[right]:
                    left = mid
                else:
                    right = mid - 1

        return False