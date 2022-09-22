class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st=new Stack<Integer>();
        int n=heights.length;
        int ans[]=new int[n];
        
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && heights[i]>st.peek()){
                st.pop();
                ans[i]++;
            }
            
            if(!st.isEmpty()){
                ans[i]++;
            }
            
            st.push(heights[i]);
        }
        
        return ans;
    }
}