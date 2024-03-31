class Solution {
public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length== 0) return 0;
        Arrays.sort(intervals, (a, b)-> a[1]-b[1]);
        int k =0, count =1, n = intervals.length;
        for(int i =1; i < n ; i++){
            if (intervals[i][0] >= intervals[k][1]){
                k = i;
                count++;
            }
        }
        return n-count;
    }
}
