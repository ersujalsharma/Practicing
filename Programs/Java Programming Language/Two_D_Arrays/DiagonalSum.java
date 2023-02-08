package Two_D_Arrays;

public class DiagonalSum {
    public static void main(String[] args) {
        int[][] arr= {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int sum=0;
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr.length; j++) {
        //         if(i==j){
        //             sum+=arr[i][j];
        //         }
        //         else if(i+j == arr.length-1){
        //             sum+=arr[i][j];
        //         }
        //     }
        // }
        for (int i = 0; i < arr.length; i++) {
            // primary both same
            sum+=arr[i][i];
            // secondary 
            // i+j == arr.length-1 ------> j = arr.length-i-1
            sum+=arr[i][arr.length-i-1];
        }
        System.out.println(sum);
    }
    
    
}
