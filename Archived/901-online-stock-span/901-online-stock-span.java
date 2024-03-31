class StockSpanner {
    Stack<Integer> st;
    ArrayList<Integer> list;
    int idx;
    public StockSpanner() {
        st=new Stack<>();
        list=new ArrayList<>();
        idx=0;
    }
    
    public int next(int price) {
        int ans=0;
        
        while(!st.isEmpty() && list.get(st.peek())<=price){
            st.pop();
        }
        
        if(st.isEmpty()){
            ans=idx+1;
        }else{
            ans=idx-st.peek();
        }
        // System.out.println(list);  
        st.push(idx);
        list.add(price); idx++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */