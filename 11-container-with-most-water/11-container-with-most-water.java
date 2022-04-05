class Solution {
    public int maxArea(int[] height) {
      int start=0,end=height.length-1;
        int ans=0;
        while(start<end){
            int mul=end-start;
            int min=Math.min(height[start],height[end]);
            ans=Math.max(ans,(mul*min));
            // System.out.print(ans+" "+mul+"-->"+min+" ");
            if(height[start]<height[end]) start++;
            else end --;
        }
        return ans;
    }
}