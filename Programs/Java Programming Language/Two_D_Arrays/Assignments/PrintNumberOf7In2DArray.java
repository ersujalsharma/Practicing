package Two_D_Arrays.Assignments;

public class PrintNumberOf7In2DArray {
    public static void main(String[] args) {
        int[][] array = { {4,7,8},{8,8,7} };
        int countNumber7=0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(array[i][j] == 7){
                    countNumber7++;
                }
            }
        }
        System.out.println(countNumber7);
    }
}
