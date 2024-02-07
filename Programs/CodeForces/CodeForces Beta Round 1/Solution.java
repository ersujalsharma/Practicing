import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            HashSet<Integer> a = new HashSet<>();
            for(int i=0;i<n;i++){
                a.add(scanner.nextInt());
            }
            HashSet<Integer> b = new HashSet<>();
            for(int i=0;i<m;i++){
                b.add(scanner.nextInt());
            }
            boolean val = solve(a,b,n,m,k);
            System.out.println(val?"YES":"NO");
        }
    }

    private static boolean solve(HashSet<Integer> a, HashSet<Integer> b, int n, int m, int k) {
        // TODO Auto-generated method stub
        return help(a,b,k/2,k/2,1,k);
    }

    private static boolean help(HashSet<Integer> a, HashSet<Integer> b, int m, int n, int i,int k) {
        // TODO Auto-generated method stub
        if(i==k+1) return true;
        if(m>0 && a.contains(i)){
            a.remove(i);
            if(help(a,b,m-1,n,i+1,k)) return true;
            a.add(i);
        }
        if(n>0 && b.contains(i)){
            b.remove(i);
            if(help(a, b, m, n-1, i+1, k)) return true;
            b.add(i);
        }
        return false;
    }
}
