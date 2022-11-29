class RandomizedSet {
    HashMap<Integer, Integer> map;

    public RandomizedSet() {
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        boolean res = map.containsKey(val);
        map.put(val, 1);
        return !res;
    }

    public boolean remove(int val) {
        boolean res = map.containsKey(val);
        // if (res) {
        //     map.put(val,map.get(val) - 1);
        // if (map.get(val) == 0)
        map.remove(val);
        // }

        return res;
    }

    public int getRandom() {
        int target = new Random().nextInt(map.size());
        int count = 0;
        for (int key : map.keySet()) {
            if(count++==target)
               return key; 
        }
        return 2;
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
