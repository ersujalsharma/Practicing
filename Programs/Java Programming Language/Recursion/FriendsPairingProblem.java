package Recursion;

/**
 * FriendsPairingProblem
 */
public class FriendsPairingProblem {

    public static void main(String[] args) {
        int ans = findWays(4);
        System.out.println(ans);
    }

    private static int findWays(int i) {
        if(i==1 || i==2){
            return i;
        }
        // if Person StandAlone then the person have only 1 way
        int StandAlone = 1 * findWays(i-1);
        // if Person in Pair then that person have (n-1) to pair 
        // he can pair with anyone except himself 
        int paired = (i-1)*findWays(i-2);
        return StandAlone+paired;
    }
}