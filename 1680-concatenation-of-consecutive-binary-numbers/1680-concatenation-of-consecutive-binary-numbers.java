class Solution {

    public int concatenatedBinary(int n) {
        long res=0; int mod=(int)1e9+7;
        int size=0;
        for(int i=1; i<=n; i++){
            if((i&(i-1))==0) size++;
            res=(res<<size)%mod;
            res=(res+i)%mod;
        }
        
        return (int)res;
    }
}