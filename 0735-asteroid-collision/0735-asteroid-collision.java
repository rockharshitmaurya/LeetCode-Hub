class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st=new Stack<>();
        
        label:
        for(int num:arr){
            
            while(!st.isEmpty() && st.peek()>0 && num<0){
                if(st.peek()<Math.abs(num)) st.pop();
                else if(st.peek()==Math.abs(num)) {st.pop(); continue label;}
                else continue label;
            }
            
            st.push(num);
        }
        
        int ans[]=new int[st.size()];
        for(int i=st.size()-1; i>=0; i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}

