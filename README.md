# Back-End Developer 
## LeetCode Solutions

This repository contains my solutions to various LeetCode problems. 
The problems are categorized by type and further divided by difficulty level.

## Current Solution Packages

- **Arrays**
  - TwoSum - Easy
  - ThreeSum - Medium
  - Trapping Rain Water - Hard
- **LinkedLists**

- **DynamicProgramming**
  
- **Graphs**
- **Strings**
- **Trees**


## Contributing
1. Place your solution in the appropriate folder based on problem type.
2. All solution classes should be prefixed with an A_, B_, C_, or Z_
  - A_ = Easy problem
  - B_ = Medium problem
  - C_ = Hard problem
  - E_ = Extreme problem
2. Follow Clean Code principles for clarity and readability.
3. Ensure filenames are clear, for example: `TwoSum.java` or `LongestSubstring.java`.
4. Class level Java Docs will be used for explanations 

## Exmaple

```java
/**
 * <h2> Solution for: Two Sum. </h2>
 * <p>
 * This class provides an efficient solution to the problem where given an array of integers and a target,
 * we need to find two indices such that the numbers at those indices add up to the target.
 * </p>
 * <p>
 * <h5>Approach:</h5>
 * </p>
 * <ul>
 *   <li>Use a HashMap to store the complement (target - current number) and the index of the current number.</li>
 *   <li>Traverse the array once, checking if the complement exists in the HashMap. If it does, return the indices.</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n) where n is the length of the input array.</li>
 *   <li>Space complexity: O(n) because we are storing at most 'n' key-value pairs in the HashMap.</li>
 * </ul>
 */
```