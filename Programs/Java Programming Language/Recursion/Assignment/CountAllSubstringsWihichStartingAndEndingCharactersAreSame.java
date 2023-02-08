package Recursion.Assignment;

public class CountAllSubstringsWihichStartingAndEndingCharactersAreSame {
    public static void main(String[] args) {
        String s = "abcab";
        int count=0;
        // for (int i = 0; i < s.length(); i++) {
        //     for (int j = i; j < s.length(); j++) {
        //         if(s.charAt(i)==s.charAt(j)){
        //             count++;
        //         }
        //     }
        // }
        // System.out.println(fun(s,0,0));
        fun(s,"",count);
    }

    private static void fun(String s, String string, int count) {
        
        if(s==""){
            if(string.charAt(0) == string.charAt(string.length()-1)){
                count++;
                System.out.println(count);
            }
            return;
        }
        if(string.length()>1){
        fun(s.substring(1), string+s.charAt(0), count);
        fun(s.substring(1), string, count);
        }
        System.out.println(count);
    }

    // private static int fun(String s, int i, int count) {
    //     if(s==""){
    //         return count;
    //     }
    //     if(i==s.length()){
    //         return count;
    //     }
    //     if(s.charAt(0)==s.charAt(i)) count++;
    //     count = fun(s,i+1,count)+fun(s.substring(1),i, count);
    //     return count;
    // }
}
