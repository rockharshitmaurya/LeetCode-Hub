class NumberContainers {
    HashMap<Integer,Integer> idx;
    HashMap<Integer,Set> value;
    public NumberContainers() {
        idx=new HashMap<>();
        value=new HashMap<>();
    }
    
    public void change(int index, int number) {
        boolean flag=true;
        if(idx.containsKey(index)){
                int exist=idx.get(index);
                value.get(exist).remove(index);
                if(value.get(exist).size()==0) value.remove(exist);
        }
            idx.put(index,number);
            if(value.containsKey(number)){
                value.get(number).add(index);
            }else{
                // PriorityQueue<Integer> pq= new PriorityQueue<Integer>(); // this gives me TLE
                Set<Integer> pq = new TreeSet<>();
                pq.add(index);
                value.put(number,pq);
            }
    }
    
    public int find(int number) {
        if(value.containsKey(number) && value.get(number).size()>0){
            
            return getFirst(value.get(number));
        }
        return -1;
    }
    
    //for getting first element from the TreeSet as there is no direct method for this in java
    int getFirst(Set<Integer> set){
        for (int val : set) {
             return val;
        }
        return 0;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */