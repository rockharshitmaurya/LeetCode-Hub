class Solution {
    public long maxArrayValue(int[] nums) {
        long ans=(long) nums[nums.length-1];
        
        Stack<Long> st=new Stack<>();
        st.push(ans);
        for(int i=nums.length-2; i>=0; i--){
            if(st.peek()>=nums[i]){
                st.push((long)st.pop()+nums[i]);
            }else{
                st.push((long)nums[i]);
            }
            ans=Math.max(ans,st.peek());
        }
        // System.out.println(st);
        return ans;
    }
}