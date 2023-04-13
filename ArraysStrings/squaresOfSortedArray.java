First approach (Sorting)

class Solution {
    public int[] sortedSquares(int[] nums) {
       for(int i=0;i<nums.length;i++){
           nums[i]=nums[i]*nums[i];
       }
        Arrays.sort(nums);
        return nums;
        
    }
}

- Square the elements in the array ans sort the array.
 
Time Complexity - o(nlogn)
Space Complexity - o(1)

Second Approach (Two pointer(one at positive and other at negative index) and extra space)
  
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=0;
        int p=0;
        int res[]=new int[nums.length];
        for(int x=0;x<nums.length;x++){
            if(nums[x]>=0){   
                break;
            }
            p++;
        }
        n=p-1;
        int i=0;
        while(n>=0 && p<nums.length){
            int s1=nums[n]*nums[n];
            int s2=nums[p]*nums[p];
            if(s1>s2){
                res[i]=s2;
                p++;
            }
            else{
                res[i]=s1;
                n--;
                
            }
            i++;
            
        }
      
        while(p<nums.length){
            res[i]=nums[p]*nums[p];
            i++;
            p++;
        }
        while(n>=0){
            res[i]=nums[n]*nums[n];
            i++;
            n--;
        }
        return res;
        
    }
}

1. Traverse through the array and get the index of first positive element (>=0).
2. one index less than the index which has positive element is a negative index.
3. We have two pointers ,one at the first postive element and other at the last negative element.
4. we will sqaure the elemnets and compare the elements at this indexes and push the smaller element into the result array and continue this until negative element index reaches 0 and positive element index reaches till the end of array.
5. Lastly copy the rest of the sqaure of elements if exist in either of indexes till it reaches 0 or end of array.
  
 Time Complexity - o(n)
 Space Complexity - o(n)
  
 Third approach (Two pointer and extra space)
  
 class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=0;
        int p=nums.length-1;
        int i=nums.length-1;
        int res[]=new int[nums.length];
        while(n<=p){
            int s1=nums[n]*nums[n];
            int s2=nums[p]*nums[p];
            if(s1>s2){
                res[i]=s1;
                n++;
            }
            else{
                res[i]=s2;
                p--;          
            }
            i--;    
        }
        return res;
        
    }
}

1.Two pointer approach.One index at start and other index at the end of array.
2.Compare two squared elements at this indexes and push the greatest element to the end of the result array.
3.Move the indexes closes as they got pushed into array until both the indexes reach.
  
Time Complexity - o(n)
Space Complexity - o(n)
  
