"""
FrontMiddleBackQueue implementation (LeetCode 1670 style).

This module provides the FrontMiddleBackQueue class which supports
pushFront, pushMiddle, pushBack, popFront, popMiddle, and popBack
operations in (amortized) O(1) time using two deques.
"""
from collections import deque


class FrontMiddleBackQueue:
    """Double-deque implementation.

    We maintain two deques, `front` and `back`, with the invariant that
    len(front) == len(back) or len(front) == len(back) + 1. The "middle"
    element is therefore always at the end of `front`.
    """

    def __init__(self):
        self.front = deque()
        self.back = deque()

    def _rebalance(self) -> None:
        # Ensure: len(front) == len(back) or len(front) == len(back) + 1
        if len(self.front) > len(self.back) + 1:
            self.back.appendleft(self.front.pop())
        elif len(self.front) < len(self.back):
            self.front.append(self.back.popleft())

    def pushFront(self, val: int) -> None:
        self.front.appendleft(val)
        self._rebalance()

    def pushMiddle(self, val: int) -> None:
        # If front is larger, move one to back to keep middle semantics,
        # then append to front (so new element becomes the end of front).
        if len(self.front) > len(self.back):
            self.back.appendleft(self.front.pop())
        self.front.append(val)
        self._rebalance()

    def pushBack(self, val: int) -> None:
        self.back.append(val)
        self._rebalance()

    def popFront(self) -> int:
        if not self.front and not self.back:
            return -1
        val = self.front.popleft() if self.front else self.back.popleft()
        self._rebalance()
        return val

    def popMiddle(self) -> int:
        if not self.front and not self.back:
            return -1
        val = self.front.pop()
        self._rebalance()
        return val

    def popBack(self) -> int:
        if not self.front and not self.back:
            return -1
        val = self.back.pop() if self.back else self.front.pop()
        self._rebalance()
        return val


# Optional quick sanity check when run directly.
if __name__ == "__main__":
    q = FrontMiddleBackQueue()
    q.pushFront(1)
    q.pushBack(2)
    q.pushMiddle(3)
    print(q.popMiddle())  # expect 3
    print(q.popFront())   # expect 1
    print(q.popBack())    # expect 2

