class Solution {
    public int minSetSize(int[] arr) {
        int count[]=new int[100005];
        int sum=0;
        
        for(int num:arr){
          count[num]++; sum++;
            // System.out.println(count[num]);
        }
        
        Arrays.sort(count);
        
        int ans=0;
        
        for(int i=100004; i>=0; i--){
            sum-=count[i];
            ans++; 
            // System.out.println(sum+" "+count[i]);
            if(sum<=(arr.length/2)) break;
        }
        return ans;
    }
}