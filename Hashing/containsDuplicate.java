class Solution {
    public boolean containsDuplicate(int[] nums) {
       
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;     
    }
}

1. Traverse the array and check if the element is present again.If it already contains return true.
  
Time complexity - o(n*n)
Space complexity - o(1)

Second approach(hashing)
  
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;     
    }
}

1. Add elements to hashmap.If it already contains return true.
  
Time complexity - o(n)
Space complexity - o(n)
