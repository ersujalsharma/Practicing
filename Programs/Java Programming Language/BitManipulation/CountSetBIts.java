package BitManipulation;

public class CountSetBIts {
    public static void main(String[] args) {
        int number = 15;
        int count =0;
        while(number>0){
            if((number&1) != 0){
                count++;
            }
            number = number>>1;
        }
        System.out.println(count);
    }
}
