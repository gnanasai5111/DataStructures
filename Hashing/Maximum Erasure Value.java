First approach(Brute force)

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> set=new HashSet<>();
            int count=0;
            for(int j=i;j<nums.length;j++){
                if(!set.contains(nums[j])){
                    set.add(nums[j]);
                    count=count+nums[j];
                }
                else{
                    break;
                }                
            }
            if(count>max){
                max=count;
            }
        }
        return max;
    }
}

1. Traverse the array from first index and find all the subarrays,if any sub array contains same element break the loop.
2. Increment the index and find the subarrays from that index and break if element repeats.
3. Repeat this process for all the elements and find max sum.
  
Time complexity - o(N*N)
Space complexity - o(N)
  
Second approach(Two pointer and hashset)
  
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max=0,count=0;
        HashSet<Integer> set=new HashSet<>();
        int left=0;
        for(int i=0;i<nums.length;i++){
            while(set.contains(nums[i])){
                set.remove(nums[left]);
                count=count-nums[left];
                left++;
            }
            set.add(nums[i]);
            count=count+nums[i];
            if(count>max){
                max=count;
            }
        }
        return max;
    }
}

1. Add the element to set.If the element already exists in the set move the left pointer and remove the element from set till the existed element got removed.
2. Find the max sum in each iteration.

Time complexity - o(N)
Space complexity - o(N)
  
Third approach(Two pointer and boolean array)
  
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max=0,count=0;
        boolean res[]=new boolean[10001];
        int left=0;
        for(int i=0;i<nums.length;i++){
            while(res[nums[i]]){
               res[nums[left]]=false;
               count=count-nums[left];
               left++;
            } 
            res[nums[i]]=true;  
            count=count+nums[i];
            max=Math.max(max,count); 
        }
        return max;
    }
}

1. Mark the elements as true in boolean array.If the element is already visited move the left pointer and mark the element as false till the existed element 
marked as false.
2. Find the max sum in each iteration.

Time complexity - o(N)
Space complexity - o(N)
  
Fourth approach(Two pointer and count array)
  
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max=0,count=0;
        int res[]=new int[10001];
        int left=0;
        for(int i=0;i<nums.length;i++){
            while(left<i && res[nums[i]]>0){
               res[nums[left]]--;
               count=count-nums[left];
               left++;
            } 
            res[nums[i]]++; 
            count=count+nums[i];
            max=Math.max(max,count); 
        }
        return max;
    }
}

1. Add the elements to count array.If the element count is greater than 1 move the left pointer and remove the elements  till the element count is equal to 1.

2. Find the max sum in each iteration.

Time complexity - o(N)
Space complexity - o(N)

Fifth approach(Hashmap and two pointer)
  
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max=0,count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0;
        for(int i=0;i<nums.length;i++){
            while(left<i && map.containsKey(nums[i]) && map.get(nums[i])>0){
               map.put(nums[left],map.get(nums[left])-1);
               count=count-nums[left];
               left++;
            } 
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            count=count+nums[i];
            max=Math.max(max,count); 
        }
        return max;
    }
}

1. Add the elements freq to hashmap.If the element count is greater than 1 move the left pointer and reduce the freq of elements  till the 
element count is equal to 1.
2. Find the max sum in each iteration.

Time complexity - o(N)
Space complexity - o(N)
    
Sixth approach(Hashmap and prefix sum)
    
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max=0,left=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int pre[]=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            pre[i+1]=pre[i]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                 left = Math.max(left, map.get(nums[i])+1);
            } 
            map.put(nums[i],i);
            max=Math.max(max,pre[i+1]-pre[left]); 
        }
        return max;
    }
}

1. Store the prefix sum in array.
2. Store the last index of elemnt in hashmap.If the element already exists find which index is greater (left or last index of the element) and make it as left
2. Find the max betwen current index and last occured index of an element

Time complexity - o(N)
Space complexity - o(N)
    
Seventh approach(count array with prefix sum)
    
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max=0,left=0;
       int res[]=new int[10001];
        int pre[]=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            pre[i+1]=pre[i]+nums[i];
        }
        Arrays.fill(res, -1);
        for(int i=0;i<nums.length;i++){
            if(res[nums[i]]!=-1){
                 left = Math.max(left, res[nums[i]]+1);
            } 
            res[nums[i]]=i;
            max=Math.max(max,pre[i+1]-pre[left]); 
        }
        return max;
    }
}

1. Store the prefix sum in array.Same as last approach but we use count array instead of hashmap.
2. Store the last index of elemnt in count array.If the element already exists find which index is greater (left or last index of the element) and make it as left.
2. Find the max betwen current index and last occured index of an element
