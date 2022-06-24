class Solution {
    public int getKth(int lo, int hi, int k) {
        int arr[][]=new int[hi-lo+1][2];
        int idx=0;
        for(int i=lo; i<=hi; i++){
            int num=i,pow=0;
            while(num!=1){
                if(num%2==0) num/=2;
                else num=3*num+1;
                
                pow++;
            }
            arr[idx][0]=i; arr[idx][1]=pow; idx++;
        }
        Arrays.sort(arr,(o1,o2)->(o1[1]-o2[1]));
        return arr[k-1][0];
        
    }
}