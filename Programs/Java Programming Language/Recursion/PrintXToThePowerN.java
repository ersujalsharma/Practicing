package Recursion;

public class PrintXToThePowerN {
    public static void main(String[] args) {
        int a = 3;
        int x = 5;
        int ans = printXToThePowerN(a,x);
        System.out.println(ans);
    }

    private static int printXToThePowerN(int a, int x) {
        /*
        if(x==0) return 1;
        return a*printXToThePowerN(a, x-1);
         */
        if(x == 0){
            return 1;
        }
        int halfPowerSquare =printXToThePowerN(a, x/2)*printXToThePowerN(a, x/2);
      
        halfPowerSquare*=halfPowerSquare;
        if((x&1)!=0)
            return halfPowerSquare*a;
        return halfPowerSquare;
    }
}
