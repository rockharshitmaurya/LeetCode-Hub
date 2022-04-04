class Solution {
    public int triangularSum(int[] nums) {
       ArrayList<Integer> list=new ArrayList<Integer>();
        for(int num:nums){
            list.add(num);
        }
        while(list.size()>1){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            for(int i=0; i<list.size()-1; i++){
                temp.add((list.get(i)+list.get(i+1))%10);
            }
            list=temp;
        }
        return list.get(0); 
    }
}