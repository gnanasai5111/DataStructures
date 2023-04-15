Minimum Value to Get Positive Step by Step Sum


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
