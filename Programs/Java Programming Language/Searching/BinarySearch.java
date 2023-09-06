package Searching;

public class BinarySearch {
    public static void main(String[] args) {
        int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 70;
        boolean ans = search(matrix,target);
        System.out.println(ans);
    }

    private static boolean search(int[][] matrix, int target) {
        int start_row = 0;
        int end_row = matrix.length-1;
        while(start_row<=end_row){
            int mid = start_row+(end_row-start_row)/2;
            if(matrix[mid][0]<=target && target<=matrix[mid][matrix[0].length-1]){
                int start_col = 0;
                int end_col = matrix[0].length-1;
                while(start_col<=end_col){
                    int innerMid = start_col+(end_col-start_col)/2;
                    if(matrix[mid][innerMid] == target) {
                        return true;
                    }
                    else if(matrix[mid][innerMid]<target){
                        start_col = innerMid+1;
                    }
                    else{
                        end_col = innerMid-1;
                    }
                }
                break;
            }
            else if(matrix[mid][0]<target){
                start_row = mid+1;
            }
            else{
                end_row = mid-1;
            }
        }
        return false;
    }
}
