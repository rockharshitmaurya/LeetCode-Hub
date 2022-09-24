class Solution {
    public int waysToMakeFair(int[] nums) {
        int n=nums.length;
        long even[]=new long[n+1],odd[]=new long[n+1];
        
        for(int i=n-1; i>=0; i--){
            if(i%2==1){
                odd[i]=odd[i+1]+nums[i];
                even[i]=even[i+1];
            }
            else {
                even[i]=even[i+1]+nums[i];
                odd[i]=odd[i+1];
            }
        }
        
        
        int count=0;
        
        long even_sum=0,odd_sum=0;
        
        
        for(int i=0; i<n; i++){
            if(even_sum+odd[i+1]==odd_sum+even[i+1]){
                count++;
                // System.out.println(i);
            } 
            if(i%2==0){
                even_sum+=nums[i];
            }else{
                odd_sum+=nums[i];
            }
        }
        
        // System.out.println(Arrays.toString(even));
        // System.out.println(Arrays.toString(odd));
        
        return count;
        
    }
}