class Solution {
    public void markIslands(char[][] grid,int r, int c, int ROWS,int COLS){
        if(r < 0 || c < 0 || r == ROWS || c == COLS || grid[r][c] == '0')
            return;
        grid[r][c] = '0';
        markIslands(grid,r,c+1,ROWS,COLS);
        markIslands(grid,r+1,c,ROWS,COLS);
        markIslands(grid,r,c-1,ROWS,COLS);
        markIslands(grid,r-1,c,ROWS,COLS);
    }
    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int numIsland = 0;
        for(int r=0;r<ROWS;r++){
            for(int c = 0;c<COLS;c++){
                if(grid[r][c] == '1'){
                    markIslands(grid,r,c,ROWS,COLS);
                    numIsland++;
                }
            }
        }
        return numIsland;
    }
}