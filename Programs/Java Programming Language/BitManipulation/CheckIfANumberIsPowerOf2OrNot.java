package BitManipulation;

public class CheckIfANumberIsPowerOf2OrNot {
    public static void main(String[] args) {
        int number = 31;
        System.out.println((number&(number-1))==0);
    }
}
