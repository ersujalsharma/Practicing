package Pattern;

public class ButterFlyPattern {
    public static void main(String[] args) {
        int star = 1;
        int space = 3;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2*space; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            System.out.println();
            star++;
            space--;
        }
        star--;
        space++;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2*space; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            System.out.println();
            star--;
            space++;
        }
    }
}
