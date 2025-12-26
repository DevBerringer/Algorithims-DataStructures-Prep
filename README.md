# Back-End Developer 
## LeetCode Solutions

This repository contains my solutions to various LeetCode problems organized by algorithmic techniques and problem types. Each solution includes comprehensive documentation, test cases, and follows clean code principles.

## Repository Structure

The solutions are organized by algorithmic techniques and problem categories:

### Arrays
- **Hashing**
  - `TwoSum.java` - Find two numbers that add up to target (Easy)
  - `TwoSumTest.java` - Comprehensive test cases
- **TwoPointers**
  - `ThreeSum.java` - Find all unique triplets that sum to zero (Medium)
  - `TrappingRainWater.java` - Calculate trapped rainwater (Hard)
  - `ThreeSumTest.java` - Test cases for ThreeSum
  - `TrappingRainWaterTest.java` - Test cases for TrappingRainWater

### Strings
- **Hashing**
  - `IsomorphicStrings.java` - Check if strings are isomorphic (Easy)
  - `RansomNote.java` - Check if ransom note can be constructed (Easy)
  - `IsomorphicStringsTest.java` - Test cases for IsomorphicStrings
  - `RansomNoteTest.java` - Test cases for RansomNote
- **SlidingWindow**
  - `LongestSubstringWithoutRepeating.java` - Find longest substring without repeating characters (Medium)
  - `LongestSubstringWithoutRepeatingTest.java` - Test cases for LongestSubstringWithoutRepeating

### Heap and Priority Queue
- **TopKFrequentElements**
  - `TopKFrequentElements.java` - Find k most frequent elements (Medium)
  - `TopKFrequentElementsTest.java` - Test cases for TopKFrequentElements
- **KthLargestElement**
  - `KthLargestElement.java` - Find kth largest element in array (Medium)
  - `KthLargestElementTest.java` - Test cases for KthLargestElement
- **LastStoneWeight**
  - `LastStoneWeight.java` - Simulate stone smashing process (Easy)
  - `LastStoneWeightTest.java` - Test cases for LastStoneWeight
- **KClosestPoints**
  - `KClosestPoints.java` - Find k closest points to origin (Medium)
  - `KClosestPointsTest.java` - Test cases for KClosestPoints
- **MergeKSortedLists**
  - `MergeKSortedLists.java` - Merge k sorted linked lists (Hard)
  - `MergeKSortedListsTest.java` - Test cases for MergeKSortedLists

### Other Categories (Ready for Future Solutions)
- **BinarySearch**
- **DynamicProgramming**
- **Graphs**
- **Greedy**
- **Hashing**
- **Intervals**
- **LinkedLists**
- **MathAndBitManipulation**
- **Matrix**
- **RecursionAndBacktracking**
- **SlidingWindow**
- **StacksAndQueues**
- **Trees**
- **Trie**
- **TwoPointers**
- **UnionFind**

## Features

### Solution Documentation
Each solution includes:
- **Problem Description**: Clear explanation of the problem
- **Approach**: Step-by-step algorithmic approach
- **Complexity Analysis**: Time and space complexity
- **Code Comments**: Inline comments for clarity
- **Main Method**: Example usage and test cases

### Test Coverage
- Comprehensive JUnit test cases
- Edge cases and boundary conditions covered
- Test cases follow naming convention: `[ClassName]Test.java`

### Code Quality
- Clean code principles applied
- Consistent naming conventions
- Proper package structure
- Comprehensive JavaDoc documentation

## Contributing Guidelines

1. **Organization**: Place solutions in appropriate technique-based subfolders
2. **Naming**: Use clear, descriptive class names (e.g., `TwoSum.java`, `LongestSubstringWithoutRepeating.java`)
3. **Documentation**: Include comprehensive JavaDoc comments with:
   - Problem description
   - Approach explanation
   - Time and space complexity
4. **Testing**: Create corresponding test classes with comprehensive test cases
5. **Code Quality**: Follow clean code principles and maintain consistency

## Example Solution Structure

```java
/**
 * <h2>Solution for: Two Sum.</h2>
 * <p>
 * This class provides a solution to find two indices in the array such that 
 * the numbers at those indices add up to the target.
 * </p>
 * <h5>Approach:</h5>
 * <ul>
 *   <li>Use a HashMap to store complements and indices</li>
 *   <li>Traverse array once, checking for complements</li>
 * </ul>
 * <h5>Complexities:</h5>
 * <ul>
 *   <li>Time complexity: O(n) where n is the length of the input array</li>
 *   <li>Space complexity: O(n) for the HashMap storage</li>
 * </ul>
 */
public class TwoSum {
    // Implementation with comprehensive comments
    // Main method with example usage
}
```

## Running Tests

To run all tests:
```bash
mvn test
```

To run specific test class:
```bash
mvn test -Dtest=TwoSumTest
```

## Technologies Used
- **Java 22**
- **JUnit 5** for testing
- **Maven** for build management
- **Clean Code Principles**
- **Comprehensive Documentation**