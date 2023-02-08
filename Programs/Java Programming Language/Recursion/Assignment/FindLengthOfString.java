package Recursion.Assignment;

public class FindLengthOfString {
    public static void main(String[] args) {
        String name = "Sujal";
        fun(name,0);
        System.out.println(fun2(name));
    }

    private static int fun2(String name) {
        if(name.length()==0){
            return 0;
        }
        return 1+fun2(name.substring(1));
    }

    private static void fun(String name, int count) {
        if(name==""){
            System.out.println(count);
            return;
        }
        fun(name.substring(1), count+1);
    }
    
}
