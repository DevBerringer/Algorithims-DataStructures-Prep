"""
Furthest Distance From Origin solution.

Given a moves string containing 'L', 'R', and '?' (wildcard), compute the
maximum possible distance from origin after optimally assigning each '?'
as 'L' or 'R'.
"""
from typing import Optional


class Solution:
    def furthestDistanceFromOrigin(self, moves: str) -> int:
        L = moves.count("L")
        R = moves.count("R")
        wild = moves.count("_")

        return abs(L - R) + wild


if __name__ == "__main__":
    examples = [
        ("L_R_L", None),
        ("____", None),
        ("LLRR", None),
        ("L_R", None),
    ]

    for moves, _ in examples:
        res = Solution().furthestDistanceFromOrigin(moves)
        print(f"moves={moves!r} -> furthest distance = {res}")

