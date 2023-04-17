First approach(Brute force)
  
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=nums.length+1;
        for(int i=0;i<nums.length;i++){
            int sum=0,index=0;
            for(int j=i;j<nums.length;j++){
                sum=sum+nums[j];
                if(min<j-i+1){
                    break;
                }
                if(sum>=target){
                    index=j-i+1;
                    break;
                }
    
                
            }
            if(index!=0 && index<min){
                min=index;
            }
        }
       
        return min==nums.length+1?0:min;
 
        
    }
}

1. Traverse all the subarrays and find minimum length among it

Time complexity - o(n*n)
Space complexity -o(1)
  
Second approach(Cumulative sum)
  
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=nums.length+1;
        int sum[]=new int[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i]=sum[i-1]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
             for (int j = i; j < nums.length; j++) {
                 int s = sum[j] - sum[i] + nums[i];
                 if (s >= target) {
                     min = Math.min(min, (j - i + 1));
                     break; 
                 }
             }
        }
       
        return min==nums.length+1?0:min;    
    }
}

1. Find the cumulative sum/prefix sum and calculate the sum of sub array at each index and find the min length when sum is greater than or equal to target.
  
Time complexity - o(n*n)
Space complexity - o(n)
  
Third approach(Sliding window)
  
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,min=nums.length+1;
        int sum=0;
        for(int right=0;right<nums.length;right++){
            sum=sum+nums[right];
            while(sum>=target){
                sum=sum-nums[left];
                if(right-left+1<min){
                    min=right-left+1;
                }
                left++;                   
            } 
        }
        return min==nums.length+1?0:min;
    }
}

1. Traverse the array and add sum, when you encounter sum greater than or equal to target ,move the left pointer till its less than target.
2. Find the length of the window whenever sum is greater than or equal to target.
3. Repeat this process till you minimum length

Time complexity - o(n)
Space complexity - o(1)
