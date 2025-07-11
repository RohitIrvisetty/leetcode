class MedianFinder:

    def __init__(self):
        self.nums=[]

    def addNum(self, num: int) -> None:
        self.nums+=[num]
        
    def findMedian(self) -> float:
        self.nums.sort()
        left,right=0,len(self.nums)-1
        if len(self.nums)%2==0:
            return (self.nums[math.ceil((left+right)/2)]+self.nums[math.floor((left+right)/2)])/2
        else:
            return self.nums[(left+right)//2]


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()