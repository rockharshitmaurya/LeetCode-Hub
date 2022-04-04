class Solution {
    public void duplicateZeros(int[] arr) {
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]==0){
                int next=arr[i+1];
                for(int j=i+1; j<arr.length-1; j++){
                    int next1=arr[j+1];
                    arr[j+1]=next;
                    next=next1;
                }
                arr[i+1]=0;
                i++;
            }
        }
    }
}