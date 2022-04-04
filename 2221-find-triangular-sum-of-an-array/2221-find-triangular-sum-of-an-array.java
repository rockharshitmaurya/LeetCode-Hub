class Solution {
    public int triangularSum(int[] nums) {
       // ArrayList<Integer> list=new ArrayList<Integer>();
       //  for(int num:nums){
       //      list.add(num);
       //  }
        int n=nums.length;
        while(n>1){
            for(int i=0; i<n-1; i++){
                nums[i]=((nums[i]+nums[i+1])%10);
            }
            // Ar
            n--;
        }
        return nums[0]; 
    }
}