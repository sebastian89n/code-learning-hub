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

