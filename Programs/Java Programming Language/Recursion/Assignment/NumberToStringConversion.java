package Recursion.Assignment;

public class NumberToStringConversion {
    static String mapValues[] = {"Zero","One","Two","Three","Four","Five",
                "Six","Seven","Eight","Nine"
                    };
    public static void main(String[] args) {
        int num=1947;
        funNumberIntoWords(num+"",0,"");
    }
    private static void funNumberIntoWords(String string, int i,String ans) {
        if(i==string.length()){
            System.out.println(ans);
            return;
        }
        String val = mapValues[string.charAt(i)-'0'];
        funNumberIntoWords(string, i+1,ans+val+" ");
    }
}
