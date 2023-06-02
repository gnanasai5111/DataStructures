A school is trying to take an annual photo of all the students. The students are asked to stand in a single file 
line in non-decreasing order by height. Let this ordering be represented by the integer array expected
where expected[i] is the expected height of the ith student in line.
You are given an integer array heights representing the current order that the students are standing in.
Each heights[i] is the height of the ith student in line (0-indexed).
Return the number of indices where heights[i] != expected[i].
  
Example 1:
Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation: 
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.


class Solution {
    public int heightChecker(int[] heights) {
      int count=0;
      int res[]=new int[heights.length];
      for(int i=0;i<heights.length;i++){
        res[i]=heights[i];
      }
      for(int i=0;i<heights.length-1;i++){
        boolean flag=false;
        for(int j=0;j<heights.length-i-1;j++){
          if(heights[j]>heights[j+1]){
            int temp=heights[j];
            heights[j]=heights[j+1];
            heights[j+1]=temp;
            flag=true;
          }
        }
        if(flag==false){
          break;
        }
      }
      for(int i=0;i<heights.length;i++){
        if(res[i]!=heights[i]){
          count++;
        }
      }
      return count;
        
    }
}
1. Sort the array using bubble sort and compare the elements with original array if they are different increment count.

Time complexity - o(N*N)
Space complexity - o(1)
  
Second approach()
  
class Solution {
    public int heightChecker(int[] heights) {
      int count=0;
      int res[]=new int[101];
      for(int i=0;i<heights.length;i++){
        res[heights[i]]++;
      }
      for(int i=0;i<heights.length;i++){
        for(int j=1;j<101;j++){
          if(res[j]>0){
            if(heights[i]!=j){
              count++;
            }
            res[j]--;
            break;          
          }
        }  
      }
      return count;
        
    }
}

1. Find the count of all numbers.
2. Traverse the heights array and check if element in heights array is equal to the non zero element in res array.
3.If they arent equal increment count

Time complexity - o(N*100)- o(N)
Space complexity - o(1)
