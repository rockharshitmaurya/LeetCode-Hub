class MyCalendarThree {
    TreeMap<Integer,Integer> map;
    int max=0;
    public MyCalendarThree() {
        max=0;
        map=new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int temp=0;
        for(int val:map.values()){
            max=Math.max(max,temp+=val);
        }
        return max;
    }
}

/*
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
