package Two_D_Arrays;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr= {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int start_row = 0;
        int end_row = arr.length-1;
        int start_col = 0;
        int end_col = arr.length-1;
        while(start_row<end_row && start_col<end_col){
            //leftToRight top wall
            for (int i = start_col; i <= end_col; i++) {
                System.out.print(arr[start_row][i]+" ");
            }
            start_row++;
            // up to down right wall
            for (int i = start_row; i <= end_row; i++) {
                System.out.print(arr[i][end_col]+ " ");
            }
            end_col--;
            // right to left bottom wall
            for (int i = end_col; i >= start_col; i--) {
                System.out.print(arr[end_row][i]+ " ");
            }
            end_row--;
            // down to up left wall
            for (int i = end_row; i >= start_row; i--) {
                System.out.print(arr[i][start_col]+ " ");
            }
            start_col++;
        }
    }
}
