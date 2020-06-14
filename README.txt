//Lab 7
//Lab Partners:

//Xiaoxiang "Steven" Liu
//xliu102@u.rochester.edu
//MW 6:15PM - 7:30PM

//Grant Yap
//gyap@u.rochester.edu
//MW 2:00 - 3:15PM



Synopsis:

The heap sort code uses the textbook with slight modifications to complete the requirements for heapify and heapsort.
The HeapTest.java code uses the given integer to test the correct output to create a max heap with the heapify
method and a sorted list with the heapsort method.

The RadixSort.java code completely implements the textbook radixsort algorithm and has another form of the radix sort 
algorithm with the bit operator changes.

The results are as followed with test cases of list size 1K, 8K, 32K, 64K, and 1M integer textfiles:


1K:
original radixsort: 1.0 millisecons
bit operator radixsort: 0.0

8K:
original radixsort: 2.0
bit operator radixsort: 4.0

32K:
original radixsort: 7.0
bit operator radixsort: 12.0

64K:
original radixsort: 11.0
bit operator radixsort: 28.0

1M:
original radixsort: 230.0
bit operator radixsort: 844.0


We discovered that the greater base meant a faster runtime, so the speed of a 10 base digit would be faster 
than a 2-bit digit.