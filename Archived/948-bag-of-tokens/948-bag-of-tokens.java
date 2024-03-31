class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score=0,ans=0;
        int i=0,j=tokens.length-1;
        while(i<=j){
            if(tokens[i]<=power){
                power-=tokens[i]; score++; i++;
            }else if(score>=1){
                power+=tokens[j]; j--; score--; 
            }else{
                break;
            }
            
            ans=Math.max(score,ans);
        }
        
        return ans;
    }
}