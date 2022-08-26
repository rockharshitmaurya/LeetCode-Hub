class Solution {
    public boolean reorderedPowerOf2(int n) {
        int input[]=getHash(n);
        
        for(int i=0; i<31; i++){
            if(Arrays.equals(input,getHash(1<<i)))
                return true;
        }
        return false;
    }
    
    int[] getHash(int n){
        int arr[]=new int[10];
        while(n>0){
            arr[n%10]++;
            n/=10;
        }
        return arr;
    }
}