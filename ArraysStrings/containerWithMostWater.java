First approach(Two pointer)
  
class Solution {
    public int maxArea(int[] height) {
       int max=0; 
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int width=j-i;
                max=Math.max(max,Math.min(height[i],height[j])*width);
            }
        }
        return max;
    }
}

1.Traverse through entire rectangale(sub array) and find the maxarea.

Time complexity - o(n*n)
Space complexity - o(1)


Second approach(Two pointer)
  
  class Solution {
    public int maxArea(int[] height) {
       int max=0; 
        int l=0;
        int r=height.length-1;
        while(l<r){
            int width=r-l;
            max=Math.max(max,Math.min(height[l],height[r])*width);
            if(height[l]<=height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return max;
    }
}

1.Traverse the array using two pointer if height of left is less than or equal to right move left pointer else move right.
2.calculate area in each iteration and find max one

Time complexity - o(n)
Space complexity - o(1)
