class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0,j=people.length-1;
        int ans=0;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                ans+=1;
                i++; j--;
            }else{
                ans++; j--;
            }
        }
        
        
        return ans; 
    }
}

// 3,3,4,5