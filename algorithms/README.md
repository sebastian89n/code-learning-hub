# Algorithms

## Big O Notation

Big O notation is a mathematical notation that describes the limiting behavior of a function when the argument tends
towards a particular value or infinity. In computer science, it is commonly used to classify algorithms based on how
their running time or space requirements grow as the input size increases.

### Understanding Big O Notation

Big O notation is crucial for assessing the efficiency and scalability of algorithms. It simplifies the comparison of
algorithms by describing their performance in terms of time and space complexity. The notation can describe different
scenarios including worst-case, best-case, and average-case performance.

### Common Classes of Big O Notation (Sorted from Best to Worst Performance)

- **O(1) - Constant Time**: The execution time remains constant regardless of the input size. Examples include simple
  operations like accessing a specific element in an array by its index.

- **O(log n) - Logarithmic Time**: The execution time increases logarithmically as the input size increases. Efficient
  search operations in a sorted array, like binary search, typically have logarithmic complexity.

- **O(n) - Linear Time**: The execution time increases linearly with the input size. Typical examples are algorithms
  that process each input element once, such as calculating the sum of all elements in an array.

- **O(n log n)**: This complexity is common in efficient sorting algorithms like mergesort and heapsort, which are more
  performant than simple quadratic sorting algorithms.

- **O(n²) - Quadratic Time**: The execution time increases quadratically with the input size. This is typical for
  algorithms with nested iterations over the data, such as bubble sort or selection sort.

- **O(2^n) - Exponential Time**: The execution time doubles with each additional element in the input. Common
  examples
  are algorithms that generate all subsets of a given set (the power set) or solve the traveling salesman problem
  through brute-force search.

- **O(n!) - Factorial Time**: The execution time grows factorialy as the input size increases. This complexity is
  typical for algorithms that generate all permutations of a set, such as finding all possible orderings of a set of
  distinct elements.

### Simplifying Big O Expressions

When determining the Big O complexity of an algorithm, the focus is on how the execution time or space grows with the
size of the input, particularly under large input sizes. This means that constants and lower-order terms are generally
omitted to simplify the expression and focus on the most significant factors.

#### Why Simplify Big O Expressions?

The purpose of simplifying Big O expressions is to capture the dominant factor that has the most impact on the growth
rate as the input size increases. Constants and smaller terms become less significant in this context and do not alter
the growth rate categorization. This simplification helps in focusing on what truly matters when comparing algorithm
efficiencies.

#### Example of Simplifying Big O

Consider an algorithm where the number of steps is described by the function `2n + 2`. Here:

- **2n** represents the dominant term as it involves the input size `n`.
- **2** is a constant that does not depend on `n` and remains the same regardless of the input size.

When expressed in Big O notation, we simplify `2n + 2` to **O(n)**. The constant coefficient `2` in front of `n` and the
additional constant `2` are stripped away because they do not change the linear nature of the function as `n` becomes
very large.

### Conclusion

Understanding Big O notation helps developers and engineers make informed decisions about algorithm selection based on
anticipated data sizes and performance constraints. It provides a foundation for algorithm analysis that is critical for
designing systems that are both efficient and scalable.

## Stable vs. Unstable Sort Algorithms

### Stable Sort Algorithms

- **Definition:** A sorting algorithm is stable if it maintains the relative order of equal elements in the sorted
  output.
- **Example:** If two elements `A` and `B` have the same value and `A` appears before `B` in the input array, `A` will
  still appear before `B` in the sorted array.
- **Use Cases:** Stability is important in scenarios where the relative order of records with equal keys must be
  preserved, such as sorting a list of names by age and then by name.
- **Examples of Stable Sorts:**
    - Bubble Sort
    - Merge Sort
    - Insertion Sort
    - Tim Sort (used in Python’s sorted() and Java’s Arrays.sort())

### Unstable Sort Algorithms

- **Definition:** A sorting algorithm is unstable if it does not necessarily maintain the relative order of equal
  elements in the sorted output.
- **Example:** If two elements `A` and `B` have the same value and `A` appears before `B` in the input array, `B` might
  appear before `A` in the sorted array.
- **Use Cases:** Stability is not a concern when the relative order of equal elements does not matter, which can allow
  for more efficient sorting in some cases.
- **Examples of Unstable Sorts:**
    - Quick Sort
    - Heap Sort
    - Selection Sort

### Summary

- **Stable Sort:** Preserves the relative order of equal elements (e.g., Bubble Sort, Merge Sort).
- **Unstable Sort:** Does not guarantee the preservation of the relative order of equal elements (e.g., Quick Sort, Heap
  Sort).
- Choosing between stable and unstable sorting algorithms depends on whether maintaining the order of equal elements is
  important for your specific use case.

## Bubble Sort

### Characteristics

- **Simple Algorithm:** Bubble sort is one of the simplest sorting algorithms, easy to understand and implement.
- **Comparison-Based:** It repeatedly compares and swaps adjacent elements if they are in the wrong order.
- **In-Place Sorting:** It sorts the array without needing additional storage, aside from a few temporary variables.
- **Stable Sort:** Bubble sort maintains the relative order of equal elements.

### When to Use

- **Educational Purposes:** Ideal for teaching basic sorting concepts and algorithm analysis.
- **Nearly Sorted Data:** Efficient for datasets that are already mostly sorted, as its best-case performance is quite
  good.

### When Not to Use

- **Large Datasets:** Inefficient for large datasets due to its poor average and worst-case time complexity.
- **Performance-Critical Applications:** Other more efficient sorting algorithms like Quick Sort, Merge Sort, or Heap
  Sort are preferable.

### Algorithm

1. Start at the beginning of the array.
2. Compare the first two elements.
3. If the first element is greater than the second, swap them.
4. Move to the next pair of elements and repeat the comparison and swapping if needed.
5. Continue this process until the end of the array.
6. Repeat the entire process for all elements, reducing the effective size of the array by one each time (since the
   largest element gets "bubbled" to the end).

### Big O Notation

- **Best Case:** `O(n)` - Occurs when the array is already sorted.
- **Average Case:** `O(n^2)` - Occurs when the array elements are in random order.
- **Worst Case:** `O(n^2)` - Occurs when the array is sorted in reverse order.
- **Space Complexity:** `O(1)` - Only a constant amount of additional space is required.

### Summary

Bubble sort is an elementary sorting algorithm that is simple and easy to implement but inefficient for large datasets
due to its quadratic time complexity. It is primarily useful for educational purposes and small or nearly sorted
datasets where its simplicity can be an advantage.
