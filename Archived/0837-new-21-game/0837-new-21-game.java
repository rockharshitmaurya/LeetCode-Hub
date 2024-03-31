class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k==0) return 1.0; 
        double window_sum=0.0;
        for(int i=k; i<(k+maxPts); i++){
            if(i<=n){
                window_sum+=1;
            }else{
                break;
            }
        }
        
        double dp[]=new double[k+maxPts+1];
        
        for(int i=k-1; i>=0; i--){
            dp[i]=(window_sum/(double)maxPts);
                double remove=0.0;
                if(i+maxPts<=n){
                    remove=dp[i+maxPts]==0?1.0:dp[i+maxPts];
                }
            window_sum+=(dp[i]-remove);
            // window_sum-=remove;
        }
        
        return dp[0];
    }
}