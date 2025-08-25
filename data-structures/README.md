# Data Structures

## Arrays

### Characteristics
- **Fixed Size:** Arrays have a fixed size, meaning the number of elements is determined when the array is created and cannot be changed.
- **Indexed Access:** Elements in an array are accessed via their index, which allows for fast retrieval.
- **Homogeneous Elements:** All elements in an array are of the same type.
- **Contiguous Memory:** Elements are stored in contiguous memory locations, providing efficient access.

### When to Use
- **Known Size:** When the number of elements is known in advance and does not change.
- **Fast Access:** When quick access to elements is required, as accessing an element by its index is very fast.
- **Memory Efficiency:** When you want to store data in a memory-efficient way, as arrays have a low memory overhead compared to some other data structures.

### When Not to Use
- **Dynamic Size:** When the number of elements can change frequently, as arrays do not handle dynamic resizing efficiently.
- **Frequent Insertions/Deletions:** When you need to insert or delete elements frequently, especially in the middle of the array, since these operations are costly in terms of time complexity.
- **Heterogeneous Elements:** When you need to store elements of different types.

### Big O Notation
- **Access:** `O(1)` - Constant time access to any element by its index.
- **Search:**
    - **Linear Search:** `O(n)` - Where `n` is the number of elements. Every element might need to be checked.
    - **Binary Search:** `O(log n)` - Only if the array is sorted.
- **Insertion:**
    - **At the End:** `O(1)` - If there's available space at the end.
    - **At the Beginning or Middle:** `O(n)` - Requires shifting elements.
- **Deletion:**
    - **At the End:** `O(1)` - Direct removal.
    - **At the Beginning or Middle:** `O(n)` - Requires shifting elements.

### Summary
Arrays are a fundamental data structure with fast access times due to indexed access and contiguous memory allocation. They are best used when the size of the dataset is fixed, and quick retrieval of elements is necessary. However, their fixed size and costly insertion/deletion operations make them less suitable for dynamic datasets where the number of elements changes frequently.
