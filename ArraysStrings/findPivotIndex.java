First approach(prefix sum)
  
class Solution {
    public int pivotIndex(int[] nums) {
        int l[]=new int[nums.length];
        int r[]=new int[nums.length];
        l[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            l[i]=l[i-1]+nums[i];
        }
        r[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            r[i]=r[i+1]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(l[i]==r[i]){
                return i;
            }
        }
        return -1;
        
    }
}

Time complexity - o(n)
Space complexity - o(n)
  
1.Traverse the array from left and find left prefix sum 
2. Traverse the array from right and find right prefix sum
3.Check if sum at indexes are equal, if equal return index else return -1
  
Second approach(Prefix sum without extra space)
  
class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        int csum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
         for(int i=0;i<nums.length;i++){
             sum=sum-nums[i];
             if(sum==csum){
                 return i;
             }
            csum=csum+nums[i];
        }
        return -1;
        
    }
}

1. Firstly traverse the array and find the total sum.
2. Again when you traverse the array second time,keep the current index as pivot and left to it is the leftsum and right to it is right sum
3.Check if they are equal or not.if equal return index else return -1;

Time complexity - o(n)
Space complexity - o(1)
