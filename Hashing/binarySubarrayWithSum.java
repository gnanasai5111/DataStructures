First approach(Brute force)
  
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum=sum+nums[j];
                if(sum==goal){
                    count++;
                }
                if(sum>goal){
                    break;
                }
            }
        }
        return count;
        
    }
}

1.  Check for all the subarrays with sum equal to goal.

Time complexity - o(N*N)
Space complexity - o(1)
  
Second approach(Hashing and prefix sum)
  
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0,sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int pre[]=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            pre[i+1]=pre[i]+nums[i];
        }           
        System.out.println(Arrays.toString(pre));
        for(int i=0;i<pre.length;i++){
            if(map.containsKey(pre[i])){
                count=count+map.get(pre[i]);
            }  
            map.put(pre[i]+goal,map.getOrDefault(pre[i]+goal,0)+1);      
        }
        return count;
        
    }
}

1. Find the prefix sum. For each index , we have to find out the subarrays ending with sum equal to goal.
2. Traverse the prefix sum arrays and store prefix sum and goal in hashmap and if the prefixsum already contains then add the value of that to count 

Time complexity - o(N)
Space complexity - o(N)
  
Fourth approach(Hashing)
  
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0,sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);            
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            int target=sum-goal;
            if(map.containsKey(target)){
                count=count+map.get(target);
            }  
            map.put(sum,map.getOrDefault(sum,0)+1);      
        }
        return count;
        
    }
}

1. Traverse the array and add the elements to hashmap.Basically we are finding subarrays ending with sum goal at each index.
2. So at each index, we put the sum into hashmap and also check if the difference between sum and goal exists in hashmap.And add the value to count.
  
Time complexity - o(N)
Space complexity - o(N)
