First approach(Extra space)
  
class Solution {
    public void moveZeroes(int[] nums) {
      int res[]=new int[nums.length];
      int j=0;
      for(int i=0;i<nums.length;i++){
          if(nums[i]!=0){
              res[j]=nums[i];
              j++;
          }

      }
      for(int i=0;i<nums.length;i++){
          if(nums[i]==0){
              res[j]=nums[i];
              j++;
          }
      }
      for(int i=0;i<nums.length;i++){
            nums[i]=res[i];
      }    
    }
}

1. Firstly copy all the non zero elements then copy all zeros

Time complexity - o(n)
Space complexity - o(n)
  
  
Second approach(without extra space)
  
class Solution {
    public void moveZeroes(int[] nums) {
      int j=0;
      for(int i=0;i<nums.length;i++){
          if(nums[i]!=0){
              nums[j]=nums[i];
              j++;
          }
      }
      while(j<nums.length){
          nums[j]=0;
          j++;
      }
      
    }
}

1. Firstly copy all the non zero elements then copy all zeros

Time complexity - o(n)
Space complexity - o(1)
  
Third approach()
  
class Solution {
    public void moveZeroes(int[] nums) {
      int j=0;
      for(int i=0;i<nums.length;i++){
          if(nums[i]!=0){
              int temp=nums[i];
              nums[i]=nums[j];
              nums[j]=temp;
              j++;
          }
      }    
    }
}

1. If the elemnt is non zero swap the element.

Time complexity - o(n)
Space complexity - o(1)
