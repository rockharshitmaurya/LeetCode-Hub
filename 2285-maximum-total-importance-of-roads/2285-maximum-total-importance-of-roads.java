class Solution {
    public long maximumImportance(int n, int[][] roads) {
        ArrayList<int[]> ind=new ArrayList<>();
        for(int i=0; i<n; i++){
            ind.add(new int[]{0,i});
        }
        for(int arr[]:roads){
            ind.get(arr[0])[0]++; 
            ind.get(arr[1])[0]++;
        }

        Collections.sort(ind,(o1,o2)->(o1[0]-o2[0]));
        
//         for(int arr[]:ind){
//             System.out.print(Arrays.toString(arr)+" ");
//         }
        int val[]=new int[n];
        for(int i=n-1; i>=0; i--){
            val[ind.get(i)[1]]=i+1;
        }
        
        long ans=0;
        
        for(int arr[]:roads){
            ans+=(val[arr[0]]+val[arr[1]]);
        }
        // System.out.println(Arrays.toString(val));
        return ans;
    }
}