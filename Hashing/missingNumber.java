First approach(sort)
  
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]){
                return i;
            }
        }
        if(nums.length!=nums[nums.length-1]){
            return nums.length;
        }
        return -1;
        
    }
}

1.sort the array.Check if index is equal to value if not return value.
2. check if last index is equal to n if not return n
  

 Time complexity - o(nlogn)
 Space complexity - o(1)
  

Second Approach(Set)

class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<=nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
        
    }
}

1. Add all the numbers to set and loop through the numbers from o to n and check if it exists in the set ,if exists return value .
  
 Time complexity - o(n)
 Space complexity - o(n)
  
  
  Third approach (counter)
  
  class Solution {
    public int missingNumber(int[] nums) {
        int c[]=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            c[nums[i]]++;     
        }
        for(int i=0;i<c.length;i++){
            if(c[i]==0){
                return i;
            }
        }
        return -1;
        
    }
}

1.count the numbers  in count array.And check if count is 0 (element doesnt exist) return the index.
  
 Time complexity - o(n)
 Space complexity - o(n)
  
  
Fourth approach(math formula)
  
class Solution {
    public int missingNumber(int[] nums) {
        int sum=0,n=nums.length;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        return ((n*(n+1))/2)-sum;
        
    }
}

1. Sum all the elements in the array.
2. find the sum of n numbers and subract with sum of array and return
  
 Time complexity - o(n)
 Space complexity - o(n)
  
