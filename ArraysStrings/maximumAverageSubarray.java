1. Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. 
2. Any answer with a calculation error less than 10 power -5 will be accepted.

First Approach(Brute force)

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-k+1;i++){
            double avg=0;
            for(int j=i;j<i+k;j++){
                avg=avg+nums[j];
            }
            double val=k;
      
            avg=avg/val;
            if(avg>max){
                max=avg;
            }
        }
        return max;
        
    }
}

1. Loop through the first k items and calculate avg.
2. Next Loop through the next k items and repeat this procedure till you reach (n-k+1) index.

Time complexity -o(n*n)
Space complexity - o(1)
  
Second approach(Cumulative sum)
  
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg=0;
        int csum[]=new int[nums.length];
        csum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
           csum[i]=nums[i]+csum[i-1];
        }
        double max=csum[k-1];
        
        for(int i=k;i<nums.length;i++){
            avg=csum[i]-csum[i-k];
            max=Math.max(avg,max);
        }
        return max/k;
        
    }
}

1. In order to find the avg of k elements, we find the cumulative sum of all the elements.
2. we move the index and subtract the values which is not part of k .repeat this process till the end

Time complexity - o(n)
Space complexity - o(n)
  
  
Third Approach(Sliding window)
  
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg=0;
        for(int i=0;i<k;i++){
            avg=avg+nums[i];
        }
        double max=avg;
        
        for(int i=k;i<nums.length;i++){
            avg=avg+nums[i]-nums[i-k];
            if(avg>max){
                max=avg;
            }
        }
        return max/k;
        
    }
}

1. Firstly find the average of k items.
2. Move the window by one and calculate the avg by adding the new item and removing the items which are not part of window .
3. Repeat this process till you reach the end;

Time Complexity - o(n)
Space Complexity - o(1)
