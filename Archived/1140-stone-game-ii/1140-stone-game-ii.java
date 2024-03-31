class Solution {
    Integer dp[][];
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        dp=new Integer[n][n*2];
        int cur=helper(piles,0,1);
        int sum=0;
        for(int num:piles) {
            sum+=num;
        }
        
        return (cur+sum)/2;
    }
    
    int helper(int piles[],int idx,int m){
        if(idx==piles.length) return 0;
        int cur=0,ans=Integer.MIN_VALUE;
        if(dp[idx][m]!=null) return dp[idx][m];
        for(int x=0; x<(2*m); x++){
            int i=x+idx;   
            if(i>=piles.length) continue;
            
            cur+=piles[i];
            int score=cur-helper(piles,i+1,Math.max(x+1,m));
            ans=Math.max(ans,score);
        }

        return dp[idx][m]=ans;
    }
}

