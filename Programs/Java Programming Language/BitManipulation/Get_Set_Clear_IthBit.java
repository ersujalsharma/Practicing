package BitManipulation;

public class Get_Set_Clear_IthBit {
    public static void main(String[] args) {
        int number = 10;
        int ith = 2;
        int val = (number&(1<<ith))==0?0:1;
        System.out.println(val);
        number = number | (1<<ith); // Setting ith bit
        System.out.println(number);
        number = number & ~(1<<ith);
        System.out.println(number);
    }
}
