class Solution {
    public List<Long> maximumEvenSplit(long sum) {
        if(sum%2!=0) return new ArrayList<Long>();
        LinkedList<Long> list = new LinkedList<>();
        long mul=2;
        while(mul<=sum){
            list.offer(mul);
            sum-=mul;
            mul+=2;
        }
        list.add(sum+list.pollLast());
        return list;
    }
//     int helper(long sum,long num,ArrayList<Long> list){
//         if(num>sum) return num;
//          int l=helper(sum,num+2,list);
//        int r= helper(sum,num+4,list)
        
//         helper(sum,num+2);
//     }
}