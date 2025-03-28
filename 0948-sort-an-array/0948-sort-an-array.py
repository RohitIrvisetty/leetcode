class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        return self.mergeSort(nums)

    def mergeSort(self, nums: List[int]) -> List[int]:
        if len(nums) == 1:
            return nums
        
        left = 0
        right = len(nums)
        mid = (left + right) // 2
        leftTraversal = self.mergeSort(nums[:mid])
        rightTraversal = self.mergeSort(nums[mid:])
        mergedArray = self.merge(leftTraversal, rightTraversal)

        return mergedArray

    def merge(self, leftArray: List[int], rightArray: List[int]) -> List[int]:
        left = len(leftArray)
        right = len(rightArray)
        sortedArray = [0] * (left + right)

        i, j, k = 0, 0, 0
        while i < left and j < right:
            if leftArray[i] < rightArray[j]:
                sortedArray[k] = leftArray[i]
                k += 1
                i += 1
            else:
                sortedArray[k] = rightArray[j]
                k += 1
                j += 1
        
        while i < left:
            sortedArray[k] = leftArray[i]
            k += 1
            i += 1
        
        while j < right:
            sortedArray[k] = rightArray[j]
            k += 1
            j += 1
        
        return sortedArray

