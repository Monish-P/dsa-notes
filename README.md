# dsa-notes
* while using two pointers (i,j) ,
  * if operation is done on ith element then increase or decrease i
  * if operation is done on jth element then increase or decrease j
	* but not both

* merge step in merge sort , or union of two sorted arrays
```
def findUnion(self,a,b):
        # code here
        ans = []
        i,j = 0,0
        d = {}
        n1,n2 = len(a), len(b)
        while i<n1 and j<n2:
            if a[i]<=b[j]:
                if a[i] not in d:
                    d[a[i]] = 1
                    ans.append(a[i])
                i+=1
            elif a[i]>b[j]:
                if b[j] not in d:
                    d[b[j]] = 1
                    ans.append(b[j])
                j+=1
        while i<n1:
            if a[i] not in d:
                d[a[i]] = 1
                ans.append(a[i])
            i+=1
        while j<n2:
            if b[j] not in d:
                d[b[j]] = 1
                ans.append(b[j])
            j+=1
        return ans
```

* Two sum , when there are numbers that are not to be sorted:
  ```
  def twoSum(self, nums: List[int], target: int) -> List[int]:

        d = {}
        for i in range(len(nums)):
            if target - nums[i] in d:
                return sorted([i,d[target - nums[i]]])
            else:
  ```
implement hashmap basic approach
1. using arrays
   ```
   class MyHashMap:

    def __init__(self):
        self.map = [-1]*1000001
    def put(self, key: int, value: int) -> None:
        self.map[key] = value
    def get(self, key: int) -> int:
        return self.map[key]

    def remove(self, key: int) -> None:
        self.map[key] = -1
    

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
   ```

implement hashset basic approach
1. using arrays
   ```
class MyHashSet:

    def __init__(self):
        self.set = [False]*1000001

    def add(self, key: int) -> None:
        if not self.set[key]:
            self.set[key] = True

    def remove(self, key: int) -> None:
        self.set[key] = False

    def contains(self, key: int) -> bool:
        return self.set[key]
   ```

