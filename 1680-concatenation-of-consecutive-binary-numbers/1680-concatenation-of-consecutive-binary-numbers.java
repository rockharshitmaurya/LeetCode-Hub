class Solution {

    public int concatenatedBinary(int n) {
        long res=0; int mod=(int)1e9+7;
        
        for(int i=1; i<=n; i++){
            res=(res<<Integer.toBinaryString(i).length())%mod;
            res=(res+i)%mod;
        }
        
        return (int)res;
    }
}