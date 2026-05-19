class Solution {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    public void placeQueens(char[][] board,int r,List<List<String>> res,int n){
        if(r == n){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }
        for(int c=0;c<n;c++){
            // Check if placing queen in curr column is safe 
            if(cols.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c))
                continue;
            // mark the current positions in column, positive diagnoal, negative diagonal
            cols.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            board[r][c] = 'Q';
            placeQueens(board,r+1,res,n);
            // Unmark the positions for backtracking to find unique sets
            cols.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            board[r][c] = '.';
        }
    } 
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                board[r][c] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        placeQueens(board,0,res,n);
        return res;
    }
}