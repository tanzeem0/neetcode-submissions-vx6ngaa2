class Solution {
    public int dfs(int[][] grid,int r,int c,int rows,int cols){
        if(r < 0 || c < 0 || r == rows || c == cols || grid[r][c] == 0)
            return 0;
        grid[r][c] = 0;
        int l = dfs(grid,r,c-1,rows,cols);
        int u = dfs(grid,r-1,c,rows,cols);
        int ri = dfs(grid,r,c+1,rows,cols);
        int d = dfs(grid,r+1,c,rows,cols);
        return l + u + ri + d + 1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c] == 1){
                    maxArea = Math.max(maxArea,dfs(grid,r,c,rows,cols));
                }
            }
        }
        return maxArea;
    }
}