Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

First Approach(Brute force)
  
class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            int count=0;
            int index=0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]==0){
                    count++;
                }
                if(count>k){
                    index=j-i;
                    break;
                }
            }
            if(count<=k){
                index=nums.length-i;
            }
            if(max<index){
                max=index;
            }
        }
        return max;
        
    }
}

1. Count the number of zeroes.If the number of zeroes exceeds than k get the length of the sub array.
2. Increment the index and repeat this process till end of array.

Time Complexity - o(n*n)
Space Complexity -o(1)
