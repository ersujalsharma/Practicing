package BackTracking.Assignments;

/**
 * KnightPlacedOnABoard
 */
// All Combination
public class KnightPlacedOnABoard {

    public static void main(String[] args) {
        int arr[][] = new int[8][8];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = -1;
            }
        }
        helperfunction(arr, 0, 0, 0);
    }
    static int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    private static boolean helperfunction(int[][] arr, int row, int col, int places) {
        if (places == arr.length*arr.length) {
            System.out.println("matched");
            printArr(arr);
            return true;
        }
        if(row<0 || row>arr.length-1 || col<0 || col>arr.length-1){
            return false;
        }
        if(arr[row][col]==-1){
            arr[row][col] = places;
            for (int i = 0; i < xMove.length; i++) {
                if(helperfunction(arr, row+xMove[i], col+yMove[i], places+1)){
                    return true;
                }

            }
            arr[row][col] = -1;
        }
        return false;
    }
    static void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
// wrong approach
// if (row < arr.length - 2 && col < arr.length - 1 && arr[row + 2][col + 1] == -1) { // 2---Down //// 1 --- Right
        //     helperfunction(arr, row + 2, col + 1, places + 1);
        // }

        // if (row < arr.length - 1 && col < arr.length - 2 && arr[row + 1][col + 2] == -1) { // 1 Down 2 Right
        //     helperfunction(arr, row + 1, col + 2, places + 1);
        // }
        // if (col < arr.length - 2 && row >= 1 && arr[row - 1][col + 2] == -1) { // 1 Up 2 Right
        //     helperfunction(arr, row - 1, col + 2, places + 1);
        // }

        // if (col >= 1 && row >= 2 && arr[row - 2][col - 1] == -1) { // 2 Up 1 Left
        //     helperfunction(arr, row - 2, col - 1, places + 1);
        // }
        // if (col < arr.length - 1 && row >= 2 && arr[row - 2][col + 1] == -1) { // 2 Up 1 Right
        //     helperfunction(arr, row - 2, col + 1, places + 1);
        // }
        // if (row < arr.length - 1 && col >= 2 && arr[row + 1][col - 2] == -1) { // 1 Down 2 Left
        //     helperfunction(arr, row + 1, col - 2, places + 1);
        // }
        // if (col >= 2 && row >= 1 && arr[row - 1][col - 2] == -1) { // 1 Up 2 Left
        //     helperfunction(arr, row - 1, col - 2, places + 1);
        // }
        // if (row < arr.length - 2 && col >= 1 && arr[row + 2][col - 1] == -1) { // 2 Down 1 Left
        //     helperfunction(arr, row + 2, col - 1, places + 1);
        // }