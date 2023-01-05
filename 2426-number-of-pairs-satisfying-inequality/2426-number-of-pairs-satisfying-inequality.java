
class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        ArrayList<Integer> sortedList=new ArrayList<>();
        int n=nums1.length;
        long ans=0;
        for(int i=0; i<n; i++){
            int ele=nums1[i]-nums2[i];
            ans+=countSmallerEqual(sortedList,ele+diff);
            sortedList.add((int)countSmallerEqual(sortedList,ele),ele);
        }
        
        return ans;
    }
    
    private long countSmallerEqual(List<Integer> diffList, int target) {
        int left = 0, right = diffList.size(); 
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (diffList.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (long)left;
    }

}