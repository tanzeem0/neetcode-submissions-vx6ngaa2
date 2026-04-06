class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer,HashSet<Character>> cols = new HashMap<>();
        HashMap<String,HashSet<Character>> squares = new HashMap<>();

        int ROWS = 9, COLS = 9;
        for(int r=0;r<ROWS;r++)
        {
            for(int c=0;c<COLS;c++)
            {
                if(board[r][c] == '.') continue;
                if(!rows.computeIfAbsent(r,k-> new HashSet<>()).add(board[r][c])){
                    return false;
                }if(!cols.computeIfAbsent(c,k -> new HashSet<>()).add(board[r][c])){
                    return false;
                }
                String square = r/3 + "-" + c/3;
                if(!squares.computeIfAbsent(square,k -> new HashSet<>()).add(board[r][c])){
                    return false;
                }
            }
        }
        return true;
    }
}
