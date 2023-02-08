package Two_D_Arrays;

public class SearchInASortedMatrix {
    /* 
    public static void main(String[] args) {
        int [][]arr = {
            {10,20,30,40},
            {15,25,35,45},
            {27,29,37,48},
            {32,33,39,50},
        };
        // you have two places to move in lesser and greater direction that are RT, and leftBottom
        int row = 0;
        int col = arr.length-1;
        int key = 15;
        while(row<=arr.length-1 && col>=0){
            if(key<arr[row][col]){
                col--;
            }
            else if(key>arr[row][col]){
                row++;
            }
            else{
                System.out.println("Key Found at"+row+","+col);
                return;
            }
        }
        System.out.println("Not Found");
        return;
    }
    */  // HOMEWORK 
    public static void main(String[] args) {
        int [][]arr = {
            {10,20,30,40},
            {15,25,35,45},
            {27,29,37,48},
            {32,33,39,50},
        };
        // you have two places to move in lesser and greater direction that are RT, and leftBottom
        int row = arr.length-1;
        int col = 0;
        int key = 33;
        while(row>=0 && col<=arr.length-1){
            if(key<arr[row][col]){
                row--;
            }
            else if(key>arr[row][col]){
                col++;
            }
            else{
                System.out.println("Key Found at"+row+","+col);
                return;
            }
        }
        System.out.println("Not Found");
        return;
    }
}
