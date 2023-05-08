First approach(Sorting)
  
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> set=new HashSet<>();
        int count=0,temp=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==temp){
                count++;
            }
            else{
                if(set.contains(count)){
                    return false;
                 }
                set.add(count);
                count=1;
                temp=arr[i];
           }
        }
        if(set.contains(count)){
            return false;
        }
        return true;
        
    }
}

1. Sort the array.Count the element count and add it to hashset.If it already contains return false else return true.
  
Time complexity - o(NlogN)
Space complexity - o(N)
  
Second approach(Counter)
  
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        int freq[]=new int[2001];
        int count=0,temp=arr[0];
        for(int i=0;i<arr.length;i++){
          freq[arr[i]+1000]++;
        }
        Arrays.sort(freq);
        for(int i=0;i<2000;i++){
            if(freq[i]!=0 && freq[i]==freq[i+1]){
                return false;
            }
        }
        return true;
        
    }
}

1.Store all the elements since the range of numbers is [-1000,1000]. Keep the array size as 2000 and 1000 to each eleemnt and count the freq.
2. Sort the freq and see if freq are equal if equal return false else return true;

Time complexity - o(N+KlogK)
Space complexity - o(k)
  
Third approach(Hashing)
  
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> set=new HashSet<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0,temp=arr[0];
        for(int i=0;i<arr.length;i++){
           map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(Integer i:map.keySet()){
            if(set.contains(map.get(i))){
                return false;
            }
            set.add(map.get(i));
        }
        return true;
        
    }
}

1. Store the frequencies of elements in hashmap.
2. Traverse the hashmap and check the count of each element and add to set,if count already exists in set return false.
  
Time complexity - o(N)  
Space complexity - o(N)
  
