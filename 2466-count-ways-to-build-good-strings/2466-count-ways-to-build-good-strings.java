class Solution {
    
    HashMap<String,Integer> dp=new HashMap<>();
    int mod=(int)1e9+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        
//         int dp[]=new int[high+1];
//         dp[0]=1;
        
//         for(int i=Math.min(zero,one); i<dp.length; i++){
//             if(i-zero>=0) dp[i]=(dp[i]+dp[i-zero])%mod;
//             if(i-one>=0) dp[i]=(dp[i]+dp[i-one])%mod;
//         }
        
//         int ans=0;
        
//         for(int i=low; i<=high; i++){
//             ans=(ans+dp[i])%mod;
//         }
        
       return helper(low,high,zero,one,0,-1); 
    }
    int helper(int low, int high, int zero, int one,int len,int last){
        if(len>high) return 0;
        
        String str=len+"#"+last;
        if(dp.containsKey(str)) return dp.get(str);

        
        int add=(len>=low && len<=high)?1:0;
        
        int left=helper(low,high,zero,one,len+zero,zero);
        int right=helper(low,high,zero,one,len+one,one);
        
        
        dp.put(str,(left+right+add)%mod);
        return (left+right+add)%mod;
    }
}

// 1,1,2,3,5,0,0,0
    
    
    
// 1,2,4,8,0,0,0,0
    