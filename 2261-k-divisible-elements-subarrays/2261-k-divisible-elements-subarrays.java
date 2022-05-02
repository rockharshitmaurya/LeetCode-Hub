class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set=new HashSet<String>();
        for (int startPoint = 0; startPoint <nums.length ; startPoint++) {
          for (int grps = startPoint; grps <=nums.length ; grps++) {
             StringBuilder sb=new StringBuilder();
             int div=0;
               for (int j = startPoint ; j < grps ; j++) {
                  sb.append((char)nums[j]);
                  if(nums[j]%p==0) div++;
               }
                 if(div<=k && sb.length()!=0) set.add(sb.toString());
            
         }
         }
        return set.size();
    }
}