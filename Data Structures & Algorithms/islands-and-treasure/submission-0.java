class Solution {
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        /*
            1. minheap to store r,c,dist
            2. multisrc bfs untill reach end 
        */
        int INF = Integer.MAX_VALUE;
        int rows = grid.length, cols = grid[0].length;
        PriorityQueue<int[]> minh = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c] == 0){ // treasure
                    minh.offer(new int[]{r,c,0});
                }
            }
        }
        while(!minh.isEmpty()){
            int[] top = minh.poll();
            int r = top[0], c = top[1], dist = top[2];
            if(grid[r][c] == INF)
                grid[r][c] = dist;
            for(int[] d:dir){
                int dr = r + d[0], dc = c + d[1], newDist = dist+1;
                if(dr >= 0 && dr < rows && dc >= 0 && dc < cols && grid[dr][dc] == INF){
                    minh.offer(new int[]{dr,dc,newDist});
                } 
            }
        }
    }
}
