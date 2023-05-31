First approach(Hash Set)

class Solution {
    public boolean isPathCrossing(String path) {
        int x=0,y=0;
        HashSet<String> set=new HashSet<>();
        set.add(0+","+0);
        for(int i=0;i<path.length();i++){
            char c=path.charAt(i); 
            if(path.charAt(i)=='N'){
                y+=1;
            }
            else if(path.charAt(i)=='S'){
                y-=1;
            }
            else if(path.charAt(i)=='W'){
                x-=1;
            }
            else if(path.charAt(i)=='E'){
               x+=1;
            }
            String temp=x+","+y;
            if(set.contains(temp)){
                return true;
            }

            set.add(temp);
        }
        
        return false;
        
    }
}

1. Increment and decrement x and y values based on E,W and N,S. Add the x, y pair to set .If it already contans returns true
  
Time complexity - O(N)
Space complexity - o(1)
