Second approach(Extra space)
   
class Solution {
    public int sumOfUnique(int[] nums) {
        int res[]=new int[101];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(res[nums[i]]==0){
               res[nums[i]]=1;
               sum=sum+nums[i];
            }
            else if(res[nums[i]]==1){
                sum=sum-nums[i];
                res[nums[i]]=2;
            }
        }
        return sum;
    }
}

1. Take an array with 101 size and store the elements from nums in index of res ,if its repeating subtract the number if its not add to sum

Time complexity - o(N)
Space complexity - o(1)
  
Third approach(Hashing)
  
  class Solution {
    public int sumOfUnique(int[] nums) {
       HashMap<Integer,Boolean> res=new HashMap<>();
        int sum=0;
        for(int i=0;i<nums.length;i++){
           if(res.containsKey(nums[i])){
               if(res.get(nums[i])){
                   sum=sum-nums[i];
               }
               res.put(nums[i],false);

           }
           else{
               res.put(nums[i],true);
               sum=sum+nums[i];
           }
        }
        return sum;
    }
}

1. Take an hashmap, if the element is unique add to hashmap and mark true,if its already in hashmap then check if its true then subtract and put it as false

Time complexity - o(N)
Space complexity - o(N)

