class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(pivot);
        int count=1;
        int pos=0;
        for(int num:nums){
                // System.out.println(list);
            if(num<pivot){
                list.add(pos,num);
                pos++;
            }else if(num>pivot){
                list.add(num);
            }else if(num==pivot){
                if(count>1) list.add(pos+1,num);
                count++;
                
            }
            
        }
        count=0;
    
        for(int num:list){
            nums[count++]=num;
        }
        return nums;
    }
}