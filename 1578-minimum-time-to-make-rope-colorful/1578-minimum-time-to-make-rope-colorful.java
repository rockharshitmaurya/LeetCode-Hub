class Solution {
    public int minCost(String colors, int[] neededTime) {
        char arr[]=colors.toCharArray();
        int ans=0,sum=0,max=0;
        char prev='1';
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=prev){
                ans+=(sum-max); 
                sum=neededTime[i]; max=neededTime[i];
            }else{
                max=Math.max(max,neededTime[i]); sum+=neededTime[i];
            }
            prev=arr[i];
        }
        ans+=(sum-max); 
        return ans;
    }
}