class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        int ans=0;
        for(int i=0; i<n; i++){
            ans+=(grid[i].end() - lower_bound(grid[i].begin(), grid[i].end(), -1, greater<int>()));
        }
       return ans; 
    }
};