class Solution {
public int maximumRobots(int[] charge, int[] running, long budget) {
        
        long best_answer=0,Cuurrent_Sum=0,max_count_till_now=0;
    
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2)->(o2-o1));
        for(int i=0; i<charge.length; i++){
            
            pq.add(charge[i]); Cuurrent_Sum+=running[i];
            
            if(getScore(Cuurrent_Sum,pq.peek(),max_count_till_now+1)<=budget){
                
                best_answer=Math.max(best_answer,max_count_till_now+1); max_count_till_now++;
                
            }else if(getScore(Cuurrent_Sum,pq.peek(),max_count_till_now+1)==getScore(running[i],charge[i],1)){
                
                max_count_till_now=0; Cuurrent_Sum=0; pq.clear();
                
            }else{
                
                pq.remove(charge[i-(int)max_count_till_now]); Cuurrent_Sum-=running[i-(int)max_count_till_now];
                
            }
        }
        
        return (int)best_answer;
    }
    
        long getScore(long sum,long max,long count){
                return (max + (count * sum));
        }
}