class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:banned) set.add(num);
        int ans=0;
        long sum=0;
        for(int i=1; i<=n; i++){
            if(set.contains(i)) continue;
            
            if(sum+i<=maxSum){
                ans++; 
                sum+=i;
            }else{
                return ans;
            }
        }
        return ans;
    }
}