/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t-->0){
		    long A = scanner.nextLong();
		    long B = scanner.nextLong();
		    long X = scanner.nextLong();
		    long Y = scanner.nextLong();
		    if(A>=B) System.out.println(0);
		    else{
		        int ans = 0;
		        if(A!=1){
		            while(A<B){
		                A*=X;
		                ans++;
		            }
		        }
		        else if(B!=1){
		            while(A<B){
		                B/=Y;
		                ans++;
		            }
		        }
		        else{
		            ans = -1;
		        }
		        System.out.println(ans);
		    }
		}   
	}
}
