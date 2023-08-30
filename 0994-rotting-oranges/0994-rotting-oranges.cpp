class Solution {
public:
    int dir[4][2]={{1,0},{0,1},{-1,0},{0,-1}};
    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<int,int>>q;
        int cntfresh=0;
        int n=grid.size(),m=grid[0].size();
        vector<vector<int>>vis(n,vector<int>(m,0));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.push({i,j});
                    vis[i][j]=2;
                }else if(grid[i][j]==1) cntfresh++;
            }
        }
        int time=0;
        while(!q.empty()){
            int size=q.size();
            bool flag=0;
            for(int i=0;i<size;i++){
                int r=q.front().first, c=q.front().second;
                q.pop();
                for(int k=0;k<4;k++){
                    int newi=r+dir[k][0],newj=c+dir[k][1];
                    if(newi>=0 && newi<n && newj>=0 && newj<m && vis[newi][newj]!=2 && grid[newi][newj]!=0){
                        if(flag==0) {time++; flag=1;}
                        vis[newi][newj]=2;
                        q.push({newi,newj});
                        cntfresh--;
                    }
                }
            }
        }
        if(cntfresh>0) return -1;
        return time;
    }
};