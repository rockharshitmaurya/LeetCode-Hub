class Solution {
    HashMap<String,Integer> dp;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        dp=new HashMap<>();
        // dp=new Integer[n+1][n+1];
        return helper(0,cuts,0,n);
    }
    
    int helper(int idx,int cuts[],int start,int end){
        if(idx>=cuts.length){
            return 0;
        }
        String key=start+":"+end;
        if(dp.containsKey(key)) return dp.get(key);
        
        int ans=(int)1e9+7;
        for(int i=idx; i<cuts.length; i++){
            if(cuts[i]>=end) break;
            else if(cuts[i]<=start) continue;
            
            int cost=end-start;

            int left=helper(0,cuts,start,cuts[i]);
            int right=helper(i+1,cuts,cuts[i],end); 
            ans=Math.min(ans,(left+right+cost));
        }
        int res=ans==(int)1e9+7?0:ans;
        dp.put(key,res);
        return res;
    }
}