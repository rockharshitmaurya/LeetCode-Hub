class Solution {
    public int countArrangement(int n) {
        boolean vis[]=new boolean[n+1];
      return helper(n,0,vis,new ArrayList<Integer>());
    }
    int helper(int n,int len,boolean[] vis,ArrayList<Integer> list){
        if(len==n){
            // System.out.println(list);
            return 1;
        }
                    // System.out.println(perm);
        int ans=0;
        for(int i=1; i<=n; i++){
            if(vis[i]) continue;
            int idx=list.size()+1;
            if(idx%i==0 || i%idx==0){
                vis[i]=true;
                list.add(i);
                ans+=helper(n,len+1,vis,list);
                list.remove(list.size()-1);
                vis[i]=false;
            }
        }
        return ans;
    }
}