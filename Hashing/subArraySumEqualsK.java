First approach(Brute force)
  
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum=sum+nums[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
       
    }
}

1. Loop through the array and check all the subarray sums and see if its equal to k or not.

Time complexity - o(n*n)
Space complexity -o(1)
  
Second approach(Hashmap and prefix sum)
  
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0,sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(sum==k){
                count++;
            }
            if(map.containsKey(sum-k)){
                count=count+map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
       
    }
}

Third approach(similar to second except we store 0 in hashmap initially)

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0,sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(map.containsKey(sum-k)){
                count=count+map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
       
    }
}

1. Traverse the array and store the prefix sum count in hashmap.
2.At current index if the prefix sum is x if we are looking for sum k then check whether x-k is present in hashmap or not .
3. If present,get the occurences of x-k and add to count.
  
Time complexity - o(n)
Space complexity - o(n)
