class Solution {
    public int maximumBeauty(int[] arr, int k) {
         var count = new int[200_002];
        for (var num:arr){
            var from = Math.max(0,num-k); //inclusive
            var to   = num+k+1;           //exclusive
            count[from]++;
            count[to]--;
        }
        int cnt=0, max = 0 ;
        for (var num:count){
            max=Math.max(cnt+=num,max);
        }
        return max;
    }
}