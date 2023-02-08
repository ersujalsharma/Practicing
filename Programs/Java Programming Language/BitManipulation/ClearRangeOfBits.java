package BitManipulation;

public class ClearRangeOfBits {
    public static void main(String[] args) {
        int number = 10;
        int i = 2;
        int j = 4;
        int bitmask = (-1<<(j+1)) | ((1<<i)-1);
        number = number & bitmask;
        System.out.println(number);
    }
}
