package oops;
/**
 * Complex
 */
public class Complex {
    
    public static void main(String[] args) {
        int a1 = 2;
        int b1 = 3;
        int a2 = 4;
        int b2 = 5;
        Complex c = new Complex();
        c.sum(a1,b1,a2,b2);
        c.diffrence(a1,b1,a2,b2);
        c.product(a1,b1,a2,b2);
    }
        void sum(int a1,int b1,int a2,int b2){
            System.out.println(a1+a2+"+i"+b1+b2);
    }
    void diffrence(int a1,int b1,int a2,int b2){
        System.out.println((a1-a2)+"+i"+(b1-b2));
    }
    void product(int a1,int b1,int a2,int b2){
        System.out.println(a1*a2+(-b1*b2)+"+i"+(a1*b2+a2*b1));
    }
}