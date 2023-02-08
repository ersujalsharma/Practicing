package BitManipulation;

public class ConvertUpperToLowerCase {
    public static void main(String[] args) {
        for (int i = 'A'; i <= 'Z'; i++) {
            System.out.println((char)(i|' '));
        }
    }
}
