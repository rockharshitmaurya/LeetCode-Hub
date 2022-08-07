class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans=0;
        int i=-1,j=piles.length;
        
        while(i<j){
            i++; j-=2;
            if(i<j) ans+=piles[j];
            // System.out.print(piles[j]+" ");
        }
        // System.out.println();
        return ans;
        
    }
}
//1 2 2 4 7 8