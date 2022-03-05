class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
            // HashMap<Integer,Integer> map=new HashMap<>();
            // for(int i=0; i<mapping.length; i++){
            //     map.put(i,mapping[i]);
            // }
        int arr[][]=new int[nums.length][2];
        int id=0;
            for(int val:nums){
                String str=val+"";
                StringBuilder sb=new StringBuilder();
                for(Character c:str.toCharArray()){
                    int new_val=mapping[c-'0'];//map.get(c-'0');
                    sb.append(new_val);
                }
                arr[id][0]=val;
                arr[id++][1]=Integer.parseInt(sb.toString());
        }
        Arrays.sort(arr,(x,y)->x[1]-y[1]);
        for(int i=0; i<nums.length; i++){
            nums[i]=arr[i][0];
        
        }
        return nums;
    }
}