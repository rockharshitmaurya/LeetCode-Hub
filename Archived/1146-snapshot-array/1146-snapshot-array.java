class SnapshotArray {
    int snp;
    HashMap<Integer,HashMap<Integer,Integer>> map;
    public SnapshotArray(int length) {
        snp=0; map=new HashMap<>();
    }
    
    public void set(int index, int val) {
        if(!map.containsKey(snp)) map.put(snp,new HashMap<>());
        map.get(snp).put(index,val);
    }
    
    public int snap() {
       return snp++;
    }
    
    public int get(int index, int snap_id) {
        if(snap_id==-1) return 0;

        if(map.containsKey(snap_id) && map.get(snap_id).containsKey(index)){
                return map.get(snap_id).get(index);
        }
        return get(index,snap_id-1);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */