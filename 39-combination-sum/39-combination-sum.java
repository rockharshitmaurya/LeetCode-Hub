class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(candidates,0,target,ans,new ArrayList<Integer>());
        return ans;  
    }
    void helper(int arr[],int i,int target,List<List<Integer>> res,List<Integer> ds){
        if(i==arr.length){
            if(target==0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[i]<=target){
            ds.add(arr[i]);
            helper(arr,i,target-arr[i],res,ds);
            ds.remove(ds.size()-1);
        }
        helper(arr,i+1,target,res,ds);
    }
}