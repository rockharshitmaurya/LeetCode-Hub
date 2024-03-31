class TimeMap {
    
    HashMap<String,TreeMap<Integer,String>> map;

    public TimeMap() {
         map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key,new TreeMap<>());
        
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        if(map.get(key).containsKey(timestamp)) return map.get(key).get(timestamp);
        Integer lowerKey=map.get(key).lowerKey(timestamp);
        if(lowerKey!=null) return map.get(key).get(lowerKey);
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */