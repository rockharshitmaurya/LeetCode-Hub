class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(o1,o2)->{
            if(o1[0]!=o2[0]){
                return o1[0]-o2[0];
            }else{
                return o1[1]-o2[1];
            }
        });
        ArrayList<int[]> ans=new ArrayList<>();
        int last_idx=0,max=0;
        for(int i=0; i<intervals.length-1; i++){
                max=Math.max(max,intervals[i][1]);
            if(max<intervals[i+1][0]){
                ans.add(new int[]{intervals[last_idx][0],max});
                last_idx=i+1; max=intervals[i+1][1];
            }
        }
        if(last_idx==n-1) ans.add(intervals[n-1]);
        else ans.add(new int[]{intervals[last_idx][0],Math.max(max,intervals[n-1][1])});
        int res[][]=new int[ans.size()][2];
        for(int i=0; i<ans.size(); i++){
            res[i]=ans.get(i);
        }
       return res; 
    }
}

