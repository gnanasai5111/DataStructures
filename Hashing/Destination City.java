First approach(Brute force)
  
class Solution {
    public String destCity(List<List<String>> path) {
        for(int i=0;i<path.size();i++){
            boolean flag=false;
             for(int j=0;j<path.size();j++){
                 if(path.get(i).get(1).equals(path.get(j).get(0))){
                     flag=true;
                     break;
                 }
              }          
              if(!flag){
                  return path.get(i).get(1);
              }        
        }
        return "";      
    }
}

1. Check if the destination city is mapping to any arrival city.If its not return the destination city.
  
Time complexity - o(N*N)
Space complexity - o(1)

Second approach(Hashing)

class Solution {
    public String destCity(List<List<String>> path) {
        HashMap<String,String> map=new HashMap<>();
        String end="";
        for(int i=0;i<path.size();i++){
          map.put(path.get(i).get(0),path.get(i).get(1));    
        }
        for(int i=0;i<path.size();i++){
            if(!map.containsKey(path.get(i).get(1))){
                return path.get(i).get(1);
            } 
        }
        return "";      
    }
}

1. Map the arrival city to destination city.
2. Check if destination city is mapped to any city or not .If not mapped return that city.
  
Time complexity - o(N)
Space complexity - o(N)
