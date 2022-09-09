class Solution {
    public int numberOfWeakCharacters(int[][] pro) {
        int ans=0;
        Arrays.sort(pro,(o1,o2)->((o1[0]==o2[0])?(o1[1]-o2[1]):(o2[0]-o1[0])));
        Stack<int[]> st=new Stack<>();
        
        
        st.push(pro[0]);
        
        for(int i=1; i<pro.length; i++){
            if(pro[i][0]<st.peek()[0] && pro[i][1]<st.peek()[1]) ans++;
            else st.push(pro[i]);
        }
        
        return ans;
    }
}