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
  
Second approach(Sliding window)
 
class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0;
        int left=0;
        int count=0;
        for(int right=0;right<nums.length;right++){
                if(nums[right]==0){
                    count++;
                }
                while(left<=right && count>k){
                    max=Math.max(right-left,max);
                    if(nums[left]==0){
                        count--;
                    }
                    left++;             
                }
       
        }
        if(count<=k){
            max=Math.max(nums.length-left,max);
        }
        return max;
        
    }
}

1. Count the number of zeroes,if the zeros exceeds k find the length than move the left pointer till zeroes are less than the k.
2. Repeat this process

Time complexity - o(n)
Space complexity - o(1)


Third approach(sliding window)
  
class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0;
        int left=0;
        int count=0;
        for(int right=0;right<nums.length;right++){
                if(nums[right]==0){
                    count++;
                }
                if(count>k){
                    max=Math.max(right-left,max);
                    if(nums[left]==0){
                        count--;
                    }
                    left++;             
                }
       
        }
        if(count<=k){
            max=Math.max(nums.length-left,max);
        }
        return max;
        
    }
}

1. Count the number of zeroes,if the zeros exceeds k find the length than move the left pointer till zeroes are less than the k.
2. Repeat this process

Time complexity - o(n)
Space complexity - o(1)
  

