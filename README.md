Project Overview:
This project implements and compares three algorithms: Bubble Sort, Merge Sort, Binary Search. The goal is to measure their performance on different array sizes using System.nanoTime()

Bubble Sort O(n^2)
Compares adjacent elements and swaps them if they are in the wrong order. Repeats until the array is sorted. Uses a swapped flag to exit early if the array is already sorted
Merge Sort O(nlog n)
Splits the array in half recursively, sorts each half, then merges them back together in sorted order. Consistent performance regardless of input order
Binary Search O(log n)
Finds a target in a sorted array by repeatedly halving the search range. Requires a sorted array to work correctly

Experimental Results
Bubble Sort on 10 elements: random 7100 ns, sorted 2100 ns
Bubble Sort on 100 elements: random 187400 ns, sorted 3500 ns
Bubble Sort on 1000 elements: random 6094300 ns, sorted 12300 ns
Merge Sort on 10 elements: random 259000 ns, sorted 8800 ns
Merge Sort on 100 elements: random 72800 ns, sorted 61500 ns
Merge Sort on 1000 elements: random 581400 ns, sorted 173700 ns
Binary Search on 10 elements: found 6100 ns, not found 1900 ns
Binary Search on 100 elements: found 1700 ns, not found 1200 ns
Binary Search on 1000 elements: found 2000 ns, not found 1400 ns

Analysis
Merge Sort was significantly faster than Bubble Sort on large arrays. On 1000 elements Bubble Sort took 6094300 ns while Merge Sort took only 581400 ns. This is because Bubble Sort is O(n^2) and grows much faster than Merge Sort's O(nlog n)
Bubble Sort was very fast on already sorted arrays because the swapped flag causes it to exit after just one pass. Merge Sort always performs similarly regardless of input order
Binary Search is extremely fast even on large arrays because it eliminates half the remaining elements on each step. It requires a sorted array because it decides whether to search left or right based on the middle element, which only works if elements are in order
The results matched the expected Big-O complexity

Reflection
This project showed that algorithm choice has a huge impact on real performance. Bubble Sort and Merge Sort produce correct results but Merge Sort is around 14 times faster on 1000 elements. This difference would grow even larger on bigger datasets. The main challenge was implementing the timing correctly so that only the algorithm itself was being measured between startTime and endTime


