class Solution {
    public int numRescueBoats(int[] people, int limit) {
       Arrays.sort(people);
        int i=0,j=people.length-1,count=0;
        while(i<=j){
            int sum=people[i];
            if(sum+people[j]<=limit){
                j--;
                i++;
                count++;
            }else{
                j--;
                count++;
            } 
            // else if(i<people.length-1 && sum+people[i+1]<=limit) i++;
        }
        return count;
    }
}