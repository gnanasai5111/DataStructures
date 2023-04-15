Minimum Value to Get Positive Step by Step Sum

First approach()

class Solution {
    public int minStartValue(int[] nums) {
        int startVal=1;
        while(true){
          int total=startVal;
          boolean isValid=true;
          for(int i=0;i<nums.length;i++){
              total=total+nums[i];
              if(total<1){
                 isValid=false;
                  break;
              }
        }
            if(isValid){
                return startVal;
            }
            startVal++;
        }
    }
}

1. Since start value should be positive, we start from 1 and check till the total is greater than 1 .
    
 Time complexity - o(n*n*m)
 Space complexity - o(1)
    
Second approach(Binary search)
    
class Solution {
    public int minStartValue(int[] nums) {
        int left=1;
        int right=100*nums.length+1;
        int total=0;
      
        while(left<right){
          int middle=(right+left)/2;
          total=middle;
          boolean isValid=true;
          for(int i=0;i<nums.length;i++){
              total=total+nums[i];
              if(total<1){
                 isValid=false;
                  break;
              }
        }
            if(isValid){
                right=middle;
            }
            else{
                left=middle+1;
            }
        }
        return left;
    }
}

1. Left index as 1 and right index as 100*nums.length+1 because max element is 100 in the array.
2. Find the middle element and see if total is greater than or equal to 1 if it is then we will make right element as middle(beacuse on right all because are valid if middle is valid)
3. if total is less than 1 then make left as middle+1(beacuse all the elements before left are invalid).
4. Return the left index.
    
 Time complexity - O(n⋅log(mn))
 Space complexity - o(1)

Third approach(Cumulative sum or prefix sum)

class Solution {
    public int minStartValue(int[] nums) {
        int min=nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
            if(nums[i]<min){
                min=nums[i];     
            }
        }        
        return min<1?Math.abs(min)+1:1;
    }
}

1. Find the prefix sum at each index and check for the min value.
2. If min value is less than 1 then you have to convert it to positive and add plus 1 else return 1

Time complexity - o(n)
Space complexity - o(1)
