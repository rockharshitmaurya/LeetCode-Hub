class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int [] result = new int [queries.length];
        
        int idx = 0;
        
        Num [] numbers = new Num[nums.length];
        Num current;
        
        for (int [] query : queries){
            for (int i = 0; i < nums.length; ++i){
                current = new Num();
                current.index = i;
                current.digits = nums[i].substring(nums[i].length() - query[1]);
                numbers[i] = current;
            }
            
            Arrays.sort(numbers, (a , b) -> a.digits.compareTo(b.digits));
            
            result[idx++] = numbers[query[0] - 1].index;
        }
        
        return result;
    }
}
class Num{
    String digits;
    int index;
    
}