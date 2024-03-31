class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        long res = 0L, mod = (long)1e9 + 7;
        Arrays.sort(A);
        HashMap<Integer, Long> dp = new HashMap<>();
        for(int i=0; i<A.length; i++){
            long ans=1L;
            for(int j=0; j<i; j++){
                
                if(A[i]%A[j]!=0) continue;
                
                int A1=A[j];
                int A2=A[i]/A[j];
                
                ans=(ans+(dp.get(A1)*dp.getOrDefault(A2,0L))%mod)%mod;
            }
            dp.put(A[i],ans);
            
            res=(res+ans)%mod;
        }
        return (int)res;
    }
}