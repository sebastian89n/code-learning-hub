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

## Recursion

### Definition

Recursion is a programming technique where a function calls itself directly or indirectly in order to solve a problem.
Each recursive call tackles a smaller or simpler part of the original problem, progressing towards a solution until a
base case is reached.

### Characteristics

- **Base Case:** The condition under which the recursive function stops calling itself, preventing infinite recursion.
- **Recursive Case:** The part of the function where it calls itself with modified arguments, moving the problem towards
  the base case.
- **Self-Similarity:** The problem is broken down into smaller instances of the same problem, often simplifying the
  solution process.

### When to Use

- **Divide and Conquer:** When a problem can be divided into smaller, similar problems. Examples include sorting
  algorithms like Merge Sort and Quick Sort.
- **Tree and Graph Traversal:** For traversing hierarchical structures such as trees and graphs, like Depth-First
  Search (DFS) and Breadth-First Search (BFS).
- **Dynamic Programming:** In problems where solutions to subproblems are reused to build up the final solution, such as
  calculating the Fibonacci sequence or solving the knapsack problem.
- **Backtracking:** In algorithms that explore all possible options to find solutions, like solving puzzles (e.g.,
  Sudoku) or finding paths (e.g., N-Queens problem).

### When Not to Use

- **High Overhead:** When the overhead of multiple function calls and stack space is too high, an iterative solution may
  be more efficient.
- **Stack Limitations:** When dealing with very deep recursion, which can lead to stack overflow errors due to limited
  stack space.
- **Complexity:** When an iterative approach is simpler and more straightforward, making the code easier to understand
  and maintain.

### Examples of Recursive Algorithms

- **Sorting Algorithms:** Merge Sort, Quick Sort
- **Tree Traversal:** Preorder, Inorder, Postorder traversal
- **Graph Traversal:** Depth-First Search (DFS)
- **Dynamic Programming:** Fibonacci sequence, factorial calculation
- **Backtracking:** N-Queens problem, Sudoku solver, maze solving

### Tail Recursion

Tail recursion is a special case of recursion where the recursive call is the last operation in the function. This
allows some compilers and interpreters to optimize the recursive call, reusing the current function's stack frame for
the next call. This optimization is called tail call optimization (TCO) and can significantly reduce the overhead of
recursive calls.

Tail recursion result is calculated by the last invocation of the method alone. In contrast, non-tail recursive
functions need to retain the results of all recursive calls to calculate the final answer.

#### Characteristics of Tail Recursion

- **Efficiency:** Tail recursive functions can be optimized to use constant stack space, making them as efficient as
  iterative solutions.
- **Simplicity:** Often leads to cleaner and simpler code for problems that can be naturally expressed with recursion.

#### Example Use Cases

- **Factorial Calculation:** Tail-recursive version of the factorial function.
- **Tree Traversal:** Certain tree traversal algorithms can be written in a tail-recursive manner.
- **Accumulators:** Functions that build up a result through an accumulator variable can often be made tail-recursive.

### Summary

Recursion is a powerful programming technique used to solve complex problems by breaking them down into simpler
sub problems. It is essential in various algorithms, particularly in areas like divide and conquer, tree and graph
traversal, dynamic programming, and backtracking. However, it should be used judiciously to avoid issues like high
overhead and stack overflow.

## In-Place and Out-of-Place Algorithms

### In-Place Algorithms

- **Definition:** An algorithm is considered in-place if it transforms the input using a constant amount of extra space.
  This means it only uses a fixed amount of additional memory, regardless of the input size.
- **Characteristics:**
    - Uses a small, constant amount of extra storage.
    - Typically modifies the input data directly.
    - Often more memory-efficient.
- **Examples:**
    - Selection Sort
    - Bubble Sort
    - Insertion Sort

### Out-of-Place Algorithms

- **Definition:** An algorithm is considered out-of-place if it requires extra space proportional to the size of the
  input data. This means it uses additional memory whose amount depends on the input size.
- **Characteristics:**
    - Requires extra space that grows with the input size.
    - Does not modify the input data directly, often creating a copy of the input or using auxiliary data structures.
    - Often more flexible but uses more memory.
- **Examples:**
    - Merge Sort
    - Radix Sort
    - Any algorithm that involves creating a copy of the input data or significant auxiliary storage.

### Summary

- **In-Place Algorithms:** Modify the input data directly with a constant amount of extra space, making them
  memory-efficient but sometimes more complex to implement.
- **Out-of-Place Algorithms:** Use additional space proportional to the input size, preserving the original data and
  often being simpler to implement but less memory-efficient.

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

## Selection Sort

### Characteristics

- **Simple Algorithm:** Selection sort is easy to understand and implement.
- **Comparison-Based:** It repeatedly selects the largest element from the unsorted portion of the array and swaps it
  with the last unsorted element.
- **In-Place Sorting:** It sorts the array without needing additional storage, aside from a few temporary variables.
- **Unstable Sort:** Selection sort does not guarantee the preservation of the relative order of equal elements.

### When to Use

- **Small Datasets:** Efficient for small arrays or lists where the simplicity of the algorithm outweighs the
  inefficiency of its time complexity.
- **Memory-Constrained Environments:** Useful when memory space is limited, as it only requires a constant amount of
  additional space.
- **Educational Purposes:** Ideal for teaching basic sorting concepts and algorithm analysis.

### When Not to Use

- **Large Datasets:** Inefficient for large datasets due to its poor average and worst-case time complexity.
- **Stable Sorting Requirement:** Not suitable when stability is required, as it does not preserve the relative order of
  equal elements.

### Algorithm

1. Start with the entire array as the unsorted portion.
2. Scan the unsorted portion to find the largest element.
3. Swap the largest element found with the last element of the unsorted portion.
4. Reduce the unsorted portion by moving the boundary one element to the left.
5. Repeat the process for the remaining unsorted portion.
6. Continue until the array is fully sorted.

### Big O Notation

- **Best Case:** `O(n^2)` - Always performs the same number of comparisons, regardless of initial order.
- **Average Case:** `O(n^2)` - The number of comparisons remains quadratic in nature.
- **Worst Case:** `O(n^2)` - The number of comparisons and swaps remains quadratic.
- **Space Complexity:** `O(1)` - Only a constant amount of additional space is required.

### Summary

Selection sort is a straightforward sorting algorithm that is easy to implement but inefficient for large datasets due
to its quadratic time complexity. It is an in-place, comparison-based sort that is not stable. This variation of
selection sort works by finding the largest element and placing it at the end of the array in each iteration. It is
mainly used for educational purposes, small datasets, or memory-constrained environments.

## Insertion Sort

### Characteristics

- **Simple Algorithm:** Insertion sort is easy to understand and implement.
- **Comparison-Based:** It builds the sorted array one element at a time by repeatedly picking the next element and
  inserting it into its correct position.
- **In-Place Sorting:** It sorts the array without needing additional storage, aside from a few temporary variables.
- **Stable Sort:** Insertion sort maintains the relative order of equal elements.

### When to Use

- **Small Datasets:** Efficient for small arrays or lists where the simplicity of the algorithm outweighs the
  inefficiency of its time complexity.
- **Nearly Sorted Data:** Particularly efficient when the array is already mostly sorted, as its best-case performance
  is linear.
- **Online Sorting:** Suitable for online algorithms where elements arrive over time and need to be sorted as they come.

### When Not to Use

- **Large Datasets:** Inefficient for large datasets due to its poor average and worst-case time complexity.
- **Randomly Ordered Data:** Not ideal for large datasets with random order, as more efficient sorting algorithms exist
  for such cases.

### Algorithm

1. Start with the first element, assuming it is sorted.
2. Take the next element and compare it with the elements in the sorted portion of the array.
3. Shift all elements in the sorted portion that are greater than the current element to the right.
4. Insert the current element into its correct position in the sorted portion.
5. Repeat the process for all elements until the entire array is sorted.

### Big O Notation

- **Best Case:** `O(n)` - Occurs when the array is already sorted.
- **Average Case:** `O(n^2)` - The number of comparisons and shifts grows quadratically with the number of elements.
- **Worst Case:** `O(n^2)` - Occurs when the array is sorted in reverse order.
- **Space Complexity:** `O(1)` - Only a constant amount of additional space is required.

### Summary

Insertion sort is a simple and intuitive sorting algorithm that is efficient for small or nearly sorted datasets. It is
an in-place, comparison-based sort that is stable. While it performs poorly on large datasets with random order due to
its quadratic time complexity, it excels in scenarios where the data is nearly sorted or arrives incrementally.

## Shell Sort

### Characteristics

- **Simple and Efficient:** Shell sort is an extension of insertion sort that allows the exchange of far apart elements
  to reduce the total number of moves.
- **Comparison-Based:** It sorts by comparing elements at specific intervals and reducing these intervals over
  successive passes.
- **In-Place Sorting:** It sorts the array without needing additional storage, aside from a few temporary variables.
- **Unstable Sort:** Shell sort does not guarantee the preservation of the relative order of equal elements.

### When to Use

- **Moderate-Sized Datasets:** More efficient than insertion sort for moderately sized datasets.
- **Improved Performance:** When you need a more efficient algorithm than insertion sort but still simple to implement.
- **Memory-Constrained Environments:** Useful when memory space is limited, as it only requires a constant amount of
  additional space.

### When Not to Use

- **Large Datasets:** While better than simple quadratic algorithms, it is still outperformed by more advanced
  algorithms like Quick Sort or Merge Sort for very large datasets.
- **Stable Sorting Requirement:** Not suitable when stability is required, as it does not preserve the relative order of
  equal elements.

### Algorithm

1. Start with a large interval (gap) and reduce the gap after each pass.
2. Perform a gapped insertion sort for the current gap size:

- Compare elements that are `gap` distance apart.
- Swap elements if they are in the wrong order.

3. Reduce the gap and repeat the process.
4. Continue until the gap is reduced to 1, at which point the array should be sorted.

### Big O Notation

- **Best Case:** `O(n log n)` - Occurs with an optimal choice of gaps.
- **Average Case:** Varies between `O(n log^2 n)` and `O(n^3/2)` depending on the gap sequence used.
- **Worst Case:** `O(n^2)` - Depends on the gap sequence, but typically better than the worst case for insertion sort.
- **Space Complexity:** `O(1)` - Only a constant amount of additional space is required.

### Summary

Shell sort is an efficient and easy-to-implement sorting algorithm that generalizes insertion sort by allowing exchanges
of far apart elements. It is an in-place, comparison-based sort that is not stable. Shell sort is particularly useful
for moderate-sized datasets and offers improved performance over simple quadratic sorting algorithms. However, it is not
as efficient as more advanced sorting algorithms for very large datasets.
