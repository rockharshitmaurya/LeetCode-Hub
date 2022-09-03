class Solution {
    ArrayList<Integer> list=new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {
        
        for(int i=1; i<=9; i++){
            helper(n,k,i,""+i);
        }
        int ans[]=new int[list.size()];
        
        for(int i=0; i<ans.length; i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    
    void helper(int n,int k,int last,String num){
        if(num.length()==n){
            list.add(Integer.parseInt(num));
            return;
        }
    
          if((last-k)>-1){
              helper(n,k,(last-k),num+(last-k));
          }
          if((last+k)!=(last-k)) 
              if((last+k)<10){
                  helper(n,k,(last+k),num+(last+k));
          }
    }
}