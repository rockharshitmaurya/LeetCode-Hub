class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n=changed.length;
        if(n%2==1) return new int[0];
        int half=n/2;
        HashMap<Integer,Integer> map=new HashMap<>();
        Arrays.sort(changed);
        for(int i=0; i<n; i++){
            map.put(changed[i],map.getOrDefault(changed[i],0)+1);
        }
        int ans[]=new int[half];
        int count=0;
        for(int i=0; i<n; i++){
            // System.out.println(Arrays.toString(ans));
            if(map.containsKey(changed[i]*2) && map.containsKey(changed[i])){
                if(map.get(changed[i])==1 && changed[i]==0){
                    continue;
                }
                // System.out.println(map);
                ans[count]=changed[i];
                map.put(ans[count],map.get(ans[count])-1);
                map.put(ans[count]*2,map.get(ans[count]*2)-1);
                // System.out.println(map);
                if(map.containsKey(ans[count]) && map.get(ans[count])==0) map.remove(ans[count]);
                if(map.containsKey(ans[count]*2) && map.get(ans[count]*2)==0) map.remove(ans[count]*2);
                count++;
            }
            // else{
            //     return new int[0];
            // }
        }
        return count==half?ans:new int[0];
    }
}