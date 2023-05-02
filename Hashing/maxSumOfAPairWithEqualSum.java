First approach()

class Solution {
    public int maximumSum(int[] nums) {
        int res[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int sum=0;
            while(num>0){
                sum=sum+num%10;
                num=num/10;
            }
            res[i]=sum;
        }
        System.out.println(Arrays.toString(res));
        int max=-1;
        for(int i=0;i<res.length;i++){
            int sum=0;
            for(int j=i+1;j<res.length;j++){
                if(res[i]==res[j]){
                    sum=nums[i]+nums[j];
                     max=Math.max(max,sum);
                }
            }
        }
        return max;
        
    }
}

1. Firstly convert the numbers to sum and store in a array.
2. Traverse the array, and check max sum between 2 indexes.
  
Time complexity - o(n*n)
Space complexity - o(n)
  
Second approach(Hashing)
  
class Solution {
    public int maximumSum(int[] nums) {
        int max=-1;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int sum=0;
            int num=nums[i];
            while(num>0){
                sum=sum+num%10;
                num=num/10;
            }
            if(!map.containsKey(sum)){
               map.put(sum,new ArrayList<>());
            }
              map.get(sum).add(nums[i]);
            }
            for(Integer i:map.keySet()){
                List<Integer> curr=map.get(i);
                if (curr.size() > 1) {
                Collections.sort(curr, Collections.reverseOrder());
                max = Math.max(max, curr.get(0) + curr.get(1));
            }
            }
        return max;
        
    }
}
 
1. Firstly convert the numbers to sum and add similar sum numbers as arraylist in hashmap.
2. For each key in hashmap,sort the arraylist and get the sum of two values and find max
  
Time complexity - o(nlogn)
Space complexity - o(n)
  
  
Third approach(Hashing)
  
class Solution {
    public int maximumSum(int[] nums) {
        int res[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int sum=0;
            while(num>0){
                sum=sum+num%10;
                num=num/10;
            }
            res[i]=sum;
        }
        int max=-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<res.length;i++){
            if(map.containsKey(res[i])){
                int val=nums[map.get(res[i])];
                max=Math.max(max,nums[i]+val);
                map.put(res[i], nums[i]>val?i:map.get(res[i]));
            }
            else{
            map.put(res[i],i);
            }
        }
        return max;
        
    }
}

1. Firstly convert the numbers to sum and store in a array.
2. Traverse the array, and checkif val contains in hashmap if its find the max sum and store the max val index in hashmap 
  
Time complexity - o(n)
Space complexity - o(n)
  
  
Fourth approach(hashmap)
  
class Solution {
    public int maximumSum(int[] nums) {
        int max=-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int sum=0;
            int num=nums[i];
            while(num>0){
                sum=sum+num%10;
                num=num/10;
            }
            if(map.containsKey(sum)){
                max=Math.max(max,nums[i]+map.get(sum));
                map.put(sum,Math.max(map.get(sum),nums[i]));
            }
            else{
                map.put(sum,nums[i]);
            }
            }
        return max;
        
    }
}

1. Traverse the array, and check convert the number to sum and put in hashmap.
2. If sum already exists in hashmap update  the value to greater one and find max.
  
Time complexity - o(n)
Space complexity - o(n)
