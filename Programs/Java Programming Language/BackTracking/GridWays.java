package BackTracking;

public class GridWays {
    public static void main(String[] args) {
        int arr[][] = new int[4][4];
        gridWays(arr,0,0,arr.length-1,arr[0].length-1,"");
        System.out.println(counter);
    }
    static int counter = 0;
    private static void gridWays(int[][] arr, int i, int j, int m, int n, String string) {
        if(i==m && j==n){
            // System.out.println(string);
            counter++;
            return;
        }
        if(i<m)
        gridWays(arr, i+1, j, m, n, string+"D"); // down
        if(j<n)
        gridWays(arr, i, j+1, m, n, string+"R"); // Right
    }

    
}
