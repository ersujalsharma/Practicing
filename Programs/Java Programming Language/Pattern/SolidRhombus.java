package Pattern;

public class SolidRhombus {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < n; i++) {
            int space = n-i-1;
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
