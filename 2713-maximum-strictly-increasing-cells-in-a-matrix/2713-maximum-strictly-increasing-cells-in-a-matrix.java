// import 
class Solution {
    public int maxIncreasingCells(int[][] mat) {
        int n=mat.length,m=mat[0].length;
        
        HashMap<Integer,ArrayList<int[]>> map=new HashMap<>();
        Set<Integer> set=new TreeSet<>();
        int row[]=new int[n];
        int col[]=new int[m];
        int temp[][]=new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int val=-mat[i][j];
                
                if(!map.containsKey(val)){
                    map.put(val,new ArrayList<>());
                }
                
                map.get(val).add(new int[]{i,j});
                set.add(val);
            }
        }
        
        int ans=Integer.MIN_VALUE;
        for(int val:set){
            for(int pos[]:map.get(val)){
                int x=pos[0],y=pos[1];
                temp[x][y]=Math.max(row[x],col[y])+1;
            }
            
            for(int pos[]:map.get(val)){
                int x=pos[0],y=pos[1];
                row[x]=Math.max(row[x],temp[x][y]);
                col[y]=Math.max(col[y],temp[x][y]);
            }
        }
        
        for(int num:row) ans=Math.max(ans,num);
        for(int num:col) ans=Math.max(ans,num);
        
        return ans;
    }
}

