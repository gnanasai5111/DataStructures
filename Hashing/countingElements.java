First approach(search)
  
class Solution {
    public int countElements(int[] arr) {
        int count=0;
        for(int i=0;i<arr.length;i++){
             for(int j=0;j<arr.length;j++){
                 if(arr[i]+1==arr[j]){
                     count++;
                     break;
                 } 
        }
           
        }
        return count;
    }
}

1. Search the array if val+1 exists increment count
  
Time complexity - o(n*n)
Space complexity - o(1)

Second approach(sort)
  
class Solution {
    public int countElements(int[] arr) {
        Arrays.sort(arr);
        int count=0;
        int r=1;
        for(int i=1;i<arr.length;i++){
           if(arr[i]!=arr[i-1]){
               if(arr[i-1]+1==arr[i]){
                   count=count+r;
               }
               r=0;
           }
           r++;
        }
        return count;
    }
}

1. Sort the array.
2. Check if the current element and next element are equal ,add repeated count annd if the current elemnt is one less than the next element 
  then add repeated element and set it 0
  
Time complexity - o(nlogn)
Space complexity - o(1)
  
Third approach(set)
  
class Solution {
    public int countElements(int[] arr) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i]+1)){
                count++;
            }
        }
        return count;
    }
}

1. Add all the elements to set.
2. Loop through array and check if element+1 exists in set or not and return count.

Time complexity - o(n)
Space complexity - o(n)
