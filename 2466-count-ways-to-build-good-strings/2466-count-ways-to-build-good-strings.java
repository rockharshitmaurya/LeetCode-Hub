class Solution {
    
    // HashMap<String,Integer> dp=new HashMap<>();
    int mod=(int)1e9+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        
        int dp[]=new int[high+1];
        dp[0]=1;
        
        for(int i=0; i<dp.length; i++){
            if(i-zero>=0) dp[i]=(dp[i]+dp[i-zero])%mod;
            if(i-one>=0) dp[i]=(dp[i]+dp[i-one])%mod;
        }
        
        int ans=0;
        
        for(int i=low; i<=high; i++){
            ans=(ans+dp[i])%mod;
        }
        // System.out.println(Arrays.toString(dp));
        // return helper("",low,high,zero,one,0);
       return ans; 
    }
  // 1 2 4 8  
//     int helper(String str,int low, int high, int zero, int one,int len){
//         if(len>high) return 0;
        
        
//         if(dp.containsKey(str)) return dp.get(str);
        
//         String zero_string=str+"0"+zero+"#";
//         String one_string=str+"1"+one+"#";
        
//         int add=(len>=low && len<=high)?1:0;
        
//         int left=helper(zero_string,low,high,zero,one,len+zero);
//         int right=helper(one_string,low,high,zero,one,len+one);
        
        
//         dp.put(str,(left+right+add)%mod);
//         return (left+right+add)%mod;
//     }
}

// 1,1,2,3,5,0,0,0
    
    
    
// 1,2,4,8,0,0,0,0
    