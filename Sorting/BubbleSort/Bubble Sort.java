In this algorithm, traverse from left and compare adjacent elements and the higher one is placed at right side. 
In this way, the largest element is moved to the rightmost end at first. This process is then continued to
find the second largest and place it and so on until the data is sorted.
  
class GFG {
    static void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                     
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
          // If no swaps were done break the loop
            if (swapped == false)
                break;
        }
    }
  
  Time complexity - o(N*N)
  Space complexity - o(1)
