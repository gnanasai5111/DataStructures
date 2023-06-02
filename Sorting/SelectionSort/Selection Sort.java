Selection sort is a simple and efficient sorting algorithm that works by repeatedly selecting the smallest (or largest) 
element from the unsorted portion of the list and moving it to the sorted portion of the list

public class Solution {
    public void selectionSort(int[] arr) {
        // Mutates arr so that it is sorted via selecting the minimum element and
        // swapping it with the corresponding index
        int min_index;
        for (int i = 0; i < arr.length; i++) {
            min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            // Swap current index with minimum element in rest of list
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }
}

1. Find the Min index in each iteration and swap it with unsorted part of the array.
  
Time complexity - o(N*N)
Space complexity - o(1)
