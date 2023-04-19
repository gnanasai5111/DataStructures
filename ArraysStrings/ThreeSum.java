First approach(Two pointer)
  
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length && nums[i]<=0;i++){
          if(i==0 || nums[i-1]!=nums[i]){
             twoSum(res,i,nums);
          }
        }
        return res;
        
    }

    public void twoSum(List<List<Integer>> res,int index,int[] nums){
        int left=index+1;
        int right=nums.length-1;
        while(left<right){
            int val=nums[index]+nums[left]+nums[right];
            if(val>0){
                right--;
            }
            else if(val<0){
                left++;
            }
            else{
                 res.add(Arrays.asList(nums[index],nums[left++],nums[right--]));
                while(left<right && nums[left]==nums[left-1]){
                    left++;
                }
               
            }

        }
    }
}

1. After sorting the array, we move our pivot element nums[i] and analyze elements to its right. 
2. We find all pairs whose sum is equal -nums[i] using the two pointers pattern, so that the sum of the pivot element (nums[i]) and the pair (-nums[i]) is equal to zero.

  
Time complexity -o(n*n)
Space complexity - o(n)
  
  
Second approach(Hashset)
  
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length && nums[i]<=0;i++){
            if(i==0 || nums[i-1]!=nums[i]){
            HashSet<Integer> h=new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int val=-(nums[i]+nums[j]);
                if(h.contains(val)){
                   ArrayList<Integer> inner=new ArrayList<>();
                   inner.add(nums[i]);
                   inner.add(nums[j]);
                   inner.add(val);
                   res.add(inner);
                   while(j+1<nums.length && nums[j]==nums[j+1]){
                       j++;
                   }
                }
                    h.add(nums[j]);
            }
            }
        }
    
        return res;
        
    }
}

1. Sort the array
2. Stop the outer loop if nums[i]>0 
3. Iterate the outer loop and get the index of each element and iterate the inner loop and in each iteration add it with the outer loop index element and check for the 
   third element in the set .If it exists in set then we got resultant triplet else add it to the set.

Time complexity - o(n*n)
Space complexity - o(n)
     
Third approach(Hashing without sorting)
     
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res=new HashSet<>();
        Set<Integer> duplicates=new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!duplicates.contains(nums[i])){               // skip duplicate values
                duplicates.add(nums[i]); 
            for(int j=i+1;j<nums.length;j++){
                int val=-(nums[i]+nums[j]);
                if(seen.containsKey(val) && seen.get(val)==i){
                   ArrayList<Integer> inner=new ArrayList<>();
                   inner.add(nums[i]);
                   inner.add(nums[j]);
                   inner.add(val);
                   Collections.sort(inner);
                   res.add(inner);
                }
                   seen.put(nums[j],i);
            }
        }
        }

    
        return new ArrayList(res);
        
    }
}

1. Iterate the outer loop and get the index of each element and iterate the inner loop and in each iteration add it with the outer loop index element and check for the 
   third element in the map .If it exists in map then we got resultant triplet else add it to the map.

Time complexity - o(n*n)
Space complexity - o(n)
