First approach(Sorting)
  
class Solution {
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        int count=0;
        for (int i = arr.length - 1; i >= 0; i--) {
            count++;
            if (i == 0 || arr[i] != arr[i - 1]) {
                if (count == arr[i]) {
                    return count;
                }
                count = 0;
            }
        }
        return -1;  
    }
}

1. Sort the array.Traverse array from reverse and check the count of each elemnt.If they are equal to element return the element.

Time complexity - o(NlogN)
Space complexity - o(1)
  
Second approach(Count numbers as indexes)
  
class Solution {
    public int findLucky(int[] nums) {
        int res[]=new int[501];
        for(int i=0;i<nums.length;i++){
            res[nums[i]]++;      
        }
        for(int i=500;i>=1;i--){
            if(res[i]==i){
                return i;
            }  
        }
        return -1;
        
    }
}

1. Store the elements count in index positions in array.Traverse the array reverse and check if frequency is equal to element then return element

Time complexity - o(N)
Space complexity - o(500)-o(1)
  
Third approach(HashMap)
  
class Solution {
    public int findLucky(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);    
        }
        int max=-1;
        for(Integer i:map.keySet()){
            if(map.get(i)==i){
                if(max<i){
                    max=i;
                }
            }
              
        }
        return max;
        
    }
}

1. Store the count of elements in  hashmap.
2. Traverse the hashmap and find the larger element with frequency of the element equal to element.
  
Time complexity - o(N)
Space complexity - o(N)
