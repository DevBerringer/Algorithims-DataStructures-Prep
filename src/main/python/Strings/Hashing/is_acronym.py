"""
Is Acronym solution (simple String problem).

Implements Solution.isAcronym(words: List[str], s: str) -> bool which checks whether
concatenating the first letters of `words` equals `s`.
"""
from typing import List


class Solution:
    def isAcronym(self, words: List[str], s: str) -> bool:
        return "".join(word[0] for word in words) == s


if __name__ == "__main__":
    examples = [
        (["alice", "bob", "carol"], "abc", True),
        (["never", "gonna", "give", "you", "up"], "nggyu", True),
        (["foo", "bar"], "fb", False),
    ]

    for words, s, expected in examples:
        res = Solution().isAcronym(words, s)
        print(words, s, res, "OK" if res == expected else f"FAIL (expected {expected})")

