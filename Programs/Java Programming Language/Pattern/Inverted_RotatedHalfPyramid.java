package Pattern;

public class Inverted_RotatedHalfPyramid {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < 5; i++) {
            int space = n-i-1;
            int star = i+1;
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            System.out.println();
            space--;
            star++;
        }
    }
}
