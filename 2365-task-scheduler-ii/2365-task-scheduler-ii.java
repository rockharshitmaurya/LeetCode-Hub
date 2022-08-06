class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer,Long> map=new HashMap<>();
        long time=0;
        for(int num:tasks){
            if(map.containsKey(num)){
                map.put(num,time=Math.max(time,map.get(num)+space)+1);
            }else{
                map.put(num,++time);
            }
        }
        return time;
    }
}