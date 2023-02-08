package BitManipulation;

public class FastExponentiation {
    public static void main(String[] args) {
        int a =2;
        int n = 31;
        long ans = 1;
        while(n>0){
            if((n&1)!=0){
                ans = ans*a;
            }
            a = a*a;
            n=n>>1;
        }
        System.out.println(ans);
        
    }
}
