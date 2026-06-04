class Solution {
    public void dfs(char[][] board,int r,int c, int rows,int cols){
        if(r < 0 || r == rows || c < 0 || c == cols || board[r][c] == 'X' || board[r][c] == 'U')
            return;
        board[r][c] = 'U';
        dfs(board,r-1,c,rows,cols);
        dfs(board,r,c+1,rows,cols);
        dfs(board,r+1,c,rows,cols);
        dfs(board,r,c-1,rows,cols);
    }
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        for(int c=0;c<cols;c++){
            if(board[0][c] == 'O'){
                dfs(board,0,c,rows,cols);
            }if(board[rows-1][c] == 'O'){
                dfs(board,rows-1,c,rows,cols);
            }
        }

        for(int r=0;r<rows;r++){
            if(board[r][0] == 'O'){
                dfs(board,r,0,rows,cols);
            }if(board[r][cols-1] == 'O'){
                dfs(board,r,cols-1,rows,cols);
            }
        }
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(board[r][c] == 'U')
                    board[r][c] = 'O';
                else
                    board[r][c] = 'X';            
            }
        }
    }
}