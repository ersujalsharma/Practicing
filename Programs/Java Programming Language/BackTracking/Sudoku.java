package BackTracking;
class Sudoku {
    
    public static void main(String[] args) {
        int sudoku[][] = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0} };

        if(funSudoku(sudoku,0,0)){
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j]);
            }
            System.out.println();
        }
    }
        else{
            System.out.println("Solution doesn't exist");
        }
    }

    private static boolean funSudoku(int[][] sudoku, int row, int col) {
        if(row==9){
            return true;
        }
        
        int nextRow = row,nextCol = col+1;
        if(col+1==9){
            nextRow=row+1;
            nextCol=0;
        }
        if(sudoku[row][col]!=0){
            return funSudoku(sudoku, nextRow, nextCol);
        }
        for (int i = 1; i <= 9; i++) {
            if(isSafeToPlace(sudoku,row,col,i)){
                sudoku[row][col]=i;
                if(funSudoku(sudoku,nextRow,nextCol)){
                    return true;
                }
                sudoku[row][col]=0;
            }
        }
        return false;
    }

    private static boolean isSafeToPlace(int[][] sudoku, int row, int col, int digit) {
        for (int j = 0; j <=8; j++) {
            if(sudoku[j][col] == digit){
                return false;
            }
        }
        for (int i = 0; i <=8; i++) {
            if(sudoku[row][i] == digit){
                return false;
            }
        }
        int startingRow = (row/3)*3;
        int startingCol = (col/3)*3;
        for (int i = startingRow; i < startingRow+3; i++) {
            for (int j = startingCol; j < startingCol+3; j++) {
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
}
