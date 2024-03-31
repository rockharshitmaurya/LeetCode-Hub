class Solution {
    public int reverse(int x) {
        int res=0; 
        while(x!=0){
            int num=x%10;
            int new_res=res*10+num;
            if((new_res-num)/10 !=res) return 0;
            res=new_res;
            x/=10;
        }
        
        return res;
    }
}
//