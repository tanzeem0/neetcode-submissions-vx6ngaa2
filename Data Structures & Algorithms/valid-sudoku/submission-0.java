class Solution {
    /**
     * To check row wise - d
     * To check column wise - d
     * To check 3 x 3 wise
     */
    public boolean isValidRowWise(char[][] board, int ROWS, int COLS){
        for(int r=0;r<ROWS;r++){
            HashSet<Character> hash = new HashSet<>();
            for(int c=0;c<COLS;c++){
                if(board[r][c] == '.') continue;
                if(hash.contains(board[r][c]) == true){
                    return false;
                }else{
                    hash.add(board[r][c]);
                }
            }
        }
        return true;
    }
    public boolean isValidColWise(char[][] board, int ROWS, int COLS){
        for(int c=0;c<COLS;c++){
            HashSet<Character> hash = new HashSet<>();
            for(int r=0;r<ROWS;r++){
                if(board[r][c] == '.') continue;
                if(hash.contains(board[r][c]) == true){
                    return false;
                }else{
                    hash.add(board[r][c]);
                }
            }
        }
        return true;
    }
    public boolean isValidCubeWise(char[][] board,int ROWS,int COLS){
        for(int r1=0;r1<3;r1++){
            for(int c1=0;c1<3;c1++){
                HashSet<Character> hash = new HashSet<>();
                for(int r=r1*3;r<r1*3+3;r++){
                    for(int c=c1*3;c<c1*3+3;c++){
                        if(board[r][c] == '.') continue;
                        if(hash.contains(board[r][c]) == true){
                            return false;
                        }else{
                            hash.add(board[r][c]);
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        return isValidRowWise(board,ROWS,COLS) && isValidColWise(board,ROWS,COLS) && isValidCubeWise(board,ROWS,COLS);
    }
}