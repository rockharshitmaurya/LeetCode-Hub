class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
//         int ans=0;
//         Arrays.sort(pro,(o1,o2)->((o1[0]==o2[0])?(o1[1]-o2[1]):(o1[0]-o2[0])));
        
//         System.out.println(Arrays.deepToString(pro));
//         for(int i=0; i<pro.length; i++){
//             for(int j=i+1; j<pro.length; j++){
//                 if(pro[i][0]<pro[j][0] && pro[i][1]<pro[j][1]){
                    
//                     System.out.println(pro[i][0]+" "+pro[i][1]+"-->"+pro[j][0]+" "+pro[j][1]);
//                     ans++;
//                 }
//             }
//         }
        
//         return ans;
        int n = properties.length;
        int count = 0;
        
        Arrays.sort(properties, (a, b) -> (b[0] == a[0]) ? (a[1] - b[1]) : b[0] - a[0]);
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            
            if (properties[i][1] < max) {
                count++;
            }
            max = Math.max(max, properties[i][1]);
        }
        return count;
    }
}