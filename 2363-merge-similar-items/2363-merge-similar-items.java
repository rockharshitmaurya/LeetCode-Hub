class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
         List<List<Integer>> ans=new ArrayList<>();
        int count[]=new int[1005];
        for(int arr[]:items1) count[arr[0]]+=arr[1];
        for(int arr[]:items2) count[arr[0]]+=arr[1];
        for(int i=0; i<count.length; i++){ if(count[i]==0) continue;
                                          
            ArrayList<Integer> temp=new ArrayList<>();
            ans.add(Arrays.asList(i,count[i]));
            // temp.add(i); temp.add(count[i]); ans.add(temp);
            
        }
        return ans;
    }
}
// [[1,5],[2,4],[3,3],[4,6],[5,4],[6,2],[7,1]]