package BackTracking;

public class FindSubsets {
    public static void main(String[] args) {
        String str = "abc";
        findSubsets(str,0,"");
    }

    private static void findSubsets(String str, int i, String string) {
        if(i==str.length()){
            if(string.length()==0){
                System.out.println("null");
            }
            else{
                System.out.println(string);
            }
            return;
        }
        findSubsets(str, i+1, string);
        findSubsets(str, i+1, string+str.charAt(i));
    }
}
