package BackTracking;

public class NQueens {
    public static void main(String[] args) {
        int n=2;
        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }
        nQueens(board,0);
    }

    private static void nQueens(char[][] board, int row) {
        if(row == board.length){
            System.out.println("-------------");
            printBoard(board);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            isSafeToPlace(board,row,i){
                board[row][i]='Q';
                nQueens(board, row+1);
                board[row][i]='.';
            }
        }
    }

    private static boolean isSafeToPlace(char[][] board, int row, int col) {
        // in same column up
        for (int i = row-1; i >= 0; i--) {
            if(board[i][col]=='Q'){
                return false;
            }
        }
        // in right daigonal
        for (int i = row-1,j=col-1; i >=0&&j>=0; i--,j--) {
            if(board[i][j]=='Q')
                return false;
        }
        for (int i = row-1,j=col-1; i >=0&&j>=0; i--,j--) {
            if(board[i][j]=='Q')
                return false;
        }
        return true;
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
