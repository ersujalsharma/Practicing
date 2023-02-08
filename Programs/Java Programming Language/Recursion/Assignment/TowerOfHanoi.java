package Recursion.Assignment;

public class TowerOfHanoi {
    public static void main(String[] args) {
        char src = 'A', help = 'B',des = 'C';
        int n = 64;
        fun(n,src,des,help);
    }

    private static void fun(int n, char src, char des, char help) {
        if(n==0){
            return;
        }
        fun(n-1, src, help,des);
        System.out.println(src+"========>>>>>>>"+des);
        fun(n-1, help, des, src);
    }
}
