class Solution {
    public int minDeletion(int[] nums) {
        int ans=0;
        ArrayList<Integer> list=new ArrayList<>();
        for(int num:nums) list.add(num);
        for(int i=0; i<list.size()-1; i++){
            int a=list.get(i);
            int b=list.get(i+1);
            if(i%2==0 && a==b){
                        // System.out.println(list.get(i)+" "+list.get(i+1));    
                list.remove(i);
                i--;
                ans++;
            }
        }
        if(list.size()%2!=0){
            ans++;
        }
        // System.out.println(list);
        return ans;
    }
}