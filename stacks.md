* implement Stack using queues

```
class MyStack:

    def __init__(self):
        self.queue = []
    def push(self, x: int) -> None:
        self.queue.append(x)
        if len(self.queue) > 1:
            for i in range(len(self.queue) - 1):
                self.queue.append(self.queue.pop(0))

    def pop(self) -> int:
        return self.queue.pop(0)
        
    def top(self) -> int:
        return self.queue[0]
        

    def empty(self) -> bool:
        return self.queue == []
        

# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()
```

* implement Queues using stack

```
class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
    def push(self, x: int) -> None:
        self.stack1.append(x)
        

    def pop(self) -> int:
        while len(self.stack1) > 1:
            self.stack2.append(self.stack1.pop())
        res = self.stack1.pop()
        while len(self.stack2) > 0:
            self.stack1.append(self.stack2.pop())
        return res
    def peek(self) -> int:
        while len(self.stack1) > 1:
            self.stack2.append(self.stack1.pop())
        res = self.stack1[-1]
        while len(self.stack2) > 0:
            self.stack1.append(self.stack2.pop())
        return res

    def empty(self) -> bool:
        return self.stack1 == []
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
```


