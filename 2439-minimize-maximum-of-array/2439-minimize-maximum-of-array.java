class Solution {
    public int minimizeArrayValue(int[] nums) {
        int l=0,r=(int)1e9;
        
        int ans=0;
        
        while(l<=r){
            int mid = l + (r - l) / 2;

            
            if(blackBox(mid,nums)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        // blackBox(6,nums);
        return ans;
    }
    
    
    
    boolean blackBox(int max,int arr[]){
        long rest=0;
        
        for(int num:arr){
            if(num>max){
                int extra=num-max;
                rest-=extra;
                
                if(rest<0) return false; //this means we are not able to full fill over need
            }else{
                rest+=(max-num);
            }
        }
        return true;
    }
}