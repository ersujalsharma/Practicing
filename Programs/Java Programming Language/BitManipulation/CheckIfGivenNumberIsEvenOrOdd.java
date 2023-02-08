package BitManipulation;

public class CheckIfGivenNumberIsEvenOrOdd {
    public static void main(String[] args) {
        int number = 500;
        String val = (number&1)==0? "Even" : "Odd";
        System.out.println(val);
    }
}
