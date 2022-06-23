class NumArray {
    int seg[],arr[];
    public NumArray(int[] nums) {
        seg=new int[nums.length*4];
        arr=nums;
        build(0,0,nums.length-1);
    }
    
    public int sumRange(int left, int right) {
        return getSum(0,0,arr.length-1,left,right);
    }
    int getSum(int idx,int l,int r,int left,int right){
        if(l>=left && r<=right){
            return seg[idx];
        }
        if (l>right || r<left) {
            return 0;
        }
        int mid=(l+r)>>1;
        return getSum(2*idx+1,l,mid,left,right)+getSum(2*idx+2,mid+1,r,left,right);
    }
    void build(int idx,int start,int end){
        if(start==end){
           seg[idx]=arr[start]; 
            return;
        }
        int mid=(start+end)>>1;
        build(2*idx+1,start,mid);
        build(2*idx+2,mid+1,end);
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */