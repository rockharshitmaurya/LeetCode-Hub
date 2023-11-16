class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set=new HashSet<>();
        for(String str:nums){
            set.add(str);
        }
        Random random = new Random();
        while(true){
            StringBuilder sb=new StringBuilder();
            
            for(int i=0; i<nums[0].length(); i++){
                int rnd = random.nextInt(2);
                sb.append(rnd);
            }
            if(!set.contains(sb.toString())) return sb.toString();
            if(2==1) break;
        }
        
        return "";
    }
}