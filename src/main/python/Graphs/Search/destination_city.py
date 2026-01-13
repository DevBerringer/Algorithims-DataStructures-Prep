"""
Destination City solution (LeetCode 1436 style).

Provides Solution.destCity(paths: List[List[str]]) -> str which returns the
city without outgoing paths (the destination city).
"""
from typing import List


class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        """Return the destination city (the city with no outgoing edges).

        Args:
            paths: list of [source, destination] pairs.

        Returns:
            The destination city string, or an empty string if none found.
        """
        starts = set(a for a, _ in paths)

        for _, b in paths:
            if b not in starts:
                return b

        # Fallback if input is empty or malformed
        return ""


if __name__ == "__main__":
    example = [["London", "New York"], ["New York", "Lima"], ["Lima", "Sao Paulo"]]
    print(Solution().destCity(example))  # expect Sao Paulo

