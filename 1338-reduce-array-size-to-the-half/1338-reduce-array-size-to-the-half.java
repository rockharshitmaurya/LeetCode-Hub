class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:arr) map.put(num,map.getOrDefault(num,0)+1);
        int count[]=new int[arr.length+1];
        int sum=0;
        int index=0;
        for(int num:map.values()){
          count[index++]=num; sum+=num;
        }
        Arrays.sort(count);
        int ans=0;
        
        for(int i=arr.length; i>=0; i--){
            sum-=count[i];
            ans++; 
            // System.out.println(sum+" "+count[i]);
            if(sum<=(arr.length/2)) break;
        }
        return ans;
    }
}