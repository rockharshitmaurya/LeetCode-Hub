class Solution {
    public int longestCycle(int[] edges) {
        int n=edges.length;
        int dis[]=new int[n];
        int ans=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            ans=Math.max(ans,helper(edges,i,dis,0));
        }
        return ans;
            
    }
    int helper(int graph[],int root,int going[],int len){
        
        if(root==-1 || going[root]==-1) return -1;
        
        if(going[root]!=0) return len-going[root];
                int val=-1; going[root]=len;
                val=Math.max(val,helper(graph,graph[root],going,len+1));
        going[root]=-1;
        return val;
    }
}

// the time complexity is actually O(n) only.
// Because map[index] = -1;(set all visited node to -1) line run after a path is all completed, mean already find a cycle or the tail.

// In next for loop, line if (map[index] == -1) return = -1; will check if that path have visited, mean all node will only visited once.