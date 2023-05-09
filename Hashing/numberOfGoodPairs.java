First approach(Brute force)
  
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
        }
        return count;
        
    }
}

1. Traverse the array for each element.If elements are similar increment count.
2. Repeat the process for all the elements in array.

Time complexity - o(N*N)
Space complexity - o(1)
  
Second approach(Sorting)
  
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        Arrays.sort(nums);
        int back=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                back++;
                count=count+back;
            }
            else{
                back=0;
            }
        }
        return count;
        
    }
}

1. sort the array.If the elements are similar increment pairs and add to count .
  
Third approach(Counter)
  
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        int res[]=new int[101];
        for(int i=0;i<nums.length;i++){
           res[nums[i]]++;
        }
        for(int i=0;i<res.length;i++){
            if(res[i]>1){
                int val=res[i]-1;
                count=count+(val*(val+1))/2;                        
            }
        }
        return count;
        
    }
}

1. Store the count of each number.
2. Find the number of distinct pairs formed by repeated number

Time complexity - o(N)
Space compexity - o(100) -o(1)
Fourth approach(Hashing)
  
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Integer i:map.keySet()){
            if(map.get(i)>1){
                int val=map.get(i)-1;
                count=count+(val*(val+1))/2;                        
            }
        }
        return count;
        
    }
}

1. Store the count of each element in hashmap.
2. Suppose if there are more than equal to 2 elements then we can form ((n)(n+1))/2 pairs where n is frequencies of number minus 1.
  
Time complexity - o(N)
Space complexity - o(N)
