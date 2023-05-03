First approach(Brute force)
  
class Solution {
    public int equalPairs(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                boolean flag=true;
                for(int k=0;k<grid.length;k++){
                    if(grid[i][k]!=grid[k][j]){
                        flag=false;
                        break;
                    }
                }
                if(flag==true){
                   count++;
                }
            }
            
        }
        return count;
        
    }
}

1. Traverse the array,and compare the first row with all the columns,repeat this process till you find the similar row and columns.
  
Time complexity - o(n*n*n)
Space complexity - o(1)
  
Second approach(HashMap)
  
class Solution {
    public int equalPairs(int[][] grid) {
        int count=0;
        HashMap<String,Integer> rmap=new HashMap<>();
        for(int i=0;i<grid.length;i++){
            String row="";
            for(int j=0;j<grid[i].length;j++){
                row=row+grid[i][j]+",";
            }
            rmap.put(row,rmap.getOrDefault(row,0)+1);       
        }
         HashMap<String,Integer> cmap=new HashMap<>();
        for(int j=0;j<grid[0].length;j++){
            String column="";
            for(int i=0;i<grid.length;i++){
                column=column+grid[i][j]+",";
            }
            cmap.put(column,cmap.getOrDefault(column,0)+1);       
        }
        for(String i:rmap.keySet()){
            count+=rmap.get(i)*cmap.getOrDefault(i,0);
        }
        return count;
        
    }
}

1. Use Two hashmaps to store all the rows as string in one hashmap and store all columns as string in other hashmap.
2. Iterate through row hashmap and check if its contained in column hashmap or not

Time complexity - o(n*n)
Space complexity - o(n*n)
