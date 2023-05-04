First approach(Brute force)

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
    
Second approach(sorting)
    
class Solution {
    public boolean containsDuplicate(int[] nums) {
       Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
                if(nums[i]==nums[i-1]){
                    return true;
                }
        }
        return false;     
    }
}

1. Sort the array and traverse and check if the prev element is equal to current element.If it is return true.
  
Time complexity - o(nlogn)
Space complexity - o(1)

Third approach(hashing)
  
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
