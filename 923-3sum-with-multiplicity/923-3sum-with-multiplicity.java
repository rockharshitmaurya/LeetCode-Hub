class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int count=0;
        int mod = 1000000007;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0; i<arr.length; i++){
            count=(count+map.getOrDefault(target-arr[i],0))%mod;
            for(int j=0; j<i; j++){
                int temp=arr[i]+arr[j];
                map.put(temp,map.getOrDefault(temp,0)+1);
            }
        }
        return count;
    }
}