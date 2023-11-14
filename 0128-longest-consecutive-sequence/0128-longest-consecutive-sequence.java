class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> map=new HashSet<>();
        for(int num:nums) map.add(num);
        int count=0,ans=0;
        int max=0;
        for(int num:nums){
            int find=num;
            if(map.contains(find-1)) continue;
            while(map.contains(find)){
                // max=find;
                count++; find++;
            }
            ans=Math.max(ans,count); 
            count=0;
        }
        return ans;
    }
}