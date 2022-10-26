class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum =0;
        
        // for(int num:nums){
        //     sum+=num;
        //     System.out.print(sum%k+" ");
        // }
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            int mod = sum % k;
            // if(mod==0) return true;
            if(!map.containsKey(mod)) map.put(mod,i);
            
            int prev=map.get(mod);
            
            if((i-prev)>=2) return true;
        }
        return false;
        // for(int i=0; i<nums.length; i++){
        //     sum+= nums[i]; 
        //     int temp = 0; 
        //     for(int j=0; j<=i-2; j++){
        //         temp+=nums[j];
        //         int new_sum = sum - temp;
        //         if(new_sum%k==0) return true;
        //     }
        //     if(i>=1 && sum%k==0) return true;
        // }
        // return false;
    }
}