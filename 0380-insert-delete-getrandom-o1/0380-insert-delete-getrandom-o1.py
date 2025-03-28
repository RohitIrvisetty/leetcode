from random import choice
class RandomizedSet:

    def __init__(self):
        self.dict = {}

    def insert(self, val: int) -> bool:
        if val in self.dict:
            return False
        self.dict[val] = choice
        return True

    def remove(self, val: int) -> bool:
        if val in self.dict:
            del self.dict[val]
            return True
        return False
    def getRandom(self) -> int:
        return choice(list(self.dict.keys()))
        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()