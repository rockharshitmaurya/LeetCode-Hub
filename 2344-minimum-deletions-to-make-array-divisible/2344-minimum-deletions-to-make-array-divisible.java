class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        int n=numsDivide.length;
        int gcd=findGCD(numsDivide,n);
        
        int count=0;
        for(int num:nums){
            if(gcd%num==0) return count;
            count++;
        }
        
        return -1;
    }
     int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
 
    // Function to find gcd of array of
    // numbers
    int findGCD(int arr[], int n)
    {
        int result = arr[0];
        for (int element: arr){
            result = gcd(result, element);
 
            if(result == 1)
            {
               return 1;
            }
        }
 
        return result;
    }
}