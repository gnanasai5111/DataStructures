First approach(Brute force)
  
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }
}
  
1. Traverse all the elements and   
  
Time complexity - o(n*n)
Space complexity - o(1)
  
Second approach(Two pointer)
  
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[]=new int[2];
        int left=0,right=1;

        while(left<right){
            int val=nums[left]+nums[right];
            if(val==target){
                res[0]=left;
                res[1]=right;
                break;
            }
            else if(right==nums.length-1){
                left++;
                right=left+1;

            }
            else{
                right++;
            }
            
        }
        return res;
    }
}

1.Two pointer.Initially move the right pointer to the end.when it reaches end increment the left pointer and make right pointer as left plus one.
2. Repeat this process till you find the target value

Time complexity - o(n*n)
Space complexity - o(1)
  
Third approach(HashMap)
  
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> res=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(res.containsKey(target-nums[i])){
                return new int[] {res.get(target-nums[i]),i};
            }
            else{
            res.put(nums[i],i);
            }
        }

        return new int[]{};
      
    }
}

1. Put the values in hashmap and traverse through array and check if target-nums[i] exists in hasmap and return the indexes.

Time complexity - o(n)
Space complexity - o(n)
