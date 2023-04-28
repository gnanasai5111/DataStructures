First approach(Brute force)

class Solution {
    public int largestUniqueNumber(int[] nums) {
      int max=-1;
      for(int i=0;i<nums.length;i++){
        int count=0;
        for(int j=0;j<nums.length;j++){
          if(nums[i]==nums[j]){
            count++;
          }
          
        }
        if(count==1){
          if(max<nums[i]){
            max=nums[i];
          }
        }
      }
      return max;
        
    }
}

1. Count the occurence of each number,and find the max in each iteration.

Time complexity -o(n*n)
Space complexity - o(1)
  
Second approach(Hashing)

class Solution {
    public int largestUniqueNumber(int[] nums) {
      int max=-1;
      HashMap<Integer,Integer> map=new HashMap<>();
      for(int i=0;i<nums.length;i++){
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
      }
      for(Integer i:map.keySet()){
        if(map.get(i)==1){
          if(max<i){
            max=i;
          }
        }
      }
      return max;
        
    }
}

1. Count the occurences in Hashmap.And Iterate through hashmap and get the max value.
  
Time complexity -o(n)
Space complexity - o(n)
