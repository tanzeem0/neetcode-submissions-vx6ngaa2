class Solution {
    public void dfs(int[][] heights,boolean[][] vis,int r,int c,int rows,int cols, int prevH){
        if(r < 0 || r == rows || c < 0 || c == cols || vis[r][c] == true || heights[r][c] < prevH)
            return;
        vis[r][c] = true;
        dfs(heights,vis,r-1,c,rows,cols,heights[r][c]);
        dfs(heights,vis,r,c+1,rows,cols,heights[r][c]);
        dfs(heights,vis,r+1,c,rows,cols,heights[r][c]);
        dfs(heights,vis,r,c-1,rows,cols,heights[r][c]);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols], atlantic = new boolean[rows][cols];
        for(int c=0;c<cols;c++)
        {
            dfs(heights,pacific,0,c,rows,cols,0);
            dfs(heights,atlantic,rows-1,c,rows,cols,0);
        }
        for(int r=0;r<rows;r++){
            dfs(heights,pacific,r,0,rows,cols,0);
            dfs(heights,atlantic,r,cols-1,rows,cols,0);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(atlantic[r][c] && pacific[r][c])
                    res.add(Arrays.asList(r,c));
            }
        }
        return res;
    }
}