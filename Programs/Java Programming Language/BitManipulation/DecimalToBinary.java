package BitManipulation;

public class DecimalToBinary {
    public static void main(String[] args) {
        int num = 25;
        int binarynum=0;
        int mul =1;
        while(num>0) {
            binarynum += num%2*mul;
            mul *=10;
            num/=2;
        }
        System.out.println(binarynum);
    }
}
