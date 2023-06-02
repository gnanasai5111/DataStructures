Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the 
same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.
  
Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

First approach(Brute force)
  
class Solution {
    public void sortColors(int[] nums) {
       int min_index;
        for (int i = 0; i < nums.length; i++) {
            min_index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min_index]) {
                    min_index = j;
                }
            }
            int temp = nums[min_index];
            nums[min_index] = nums[i];
            nums[i] = temp;
        }       
    }
}

1. Use Selection sort.
  
Time complexity - o(N*N)
Space complexity - o(1)
  
Second approach(Count-Two pass)
  
class Solution {
    public void sortColors(int[] nums) {
        int o=0,z=0,t=0;
        for (int i = 0; i < nums.length; i++) {
           if(nums[i]==0){
             z++;
           }
          else if(nums[i]==1){
            o++;
          }
          else{
            t++;
          }
        } 
       for (int i = 0; i < nums.length; i++) {
         if(z>0){
           nums[i]=0;
           z--;
         }
         else if(o>0){
           nums[i]=1;
           o--;
         }
         else{
           nums[i]=2;
           t--;
         }
       }
    }
}

1. Count no of 0s,1s and 2s.Move the elements to array.
  
Time complexity - o(N)
Space complexity - o(1)
  
Third approach(Dutch national flag algorithm)
  
class Solution {
    public void sortColors(int[] nums) {
       int l=0, r=nums.length-1,mid=0;
       while(mid<=r){
         if(nums[mid]==0){
           int temp=nums[l];
           nums[l]=0;
           nums[mid]=temp;
           l++;
           mid++;
         }
         else if(nums[mid]==2){
           int temp=nums[r];
           nums[r]=2;
           nums[mid]=temp;
           r--;
         }
         else{
           mid++;
         }
       }
    }
}
  
1. Use three Pointer,two pointers at the start and one at the end.
2. Move the middle pointer,when mid pointer encounters,
  a) if 0, swap it with first pointer and increment first and mid pointer.
  b) else if 2, swap it with last pointer and decrement the last pointer.
  c) else increment the mid 
  
Time complexity - o(N)
Space complexity - o(1)
