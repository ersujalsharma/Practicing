package Strings;

public class FindShortestPathFor4Direction {
    public static void main(String[] args) {
        String dir = "WNEENESENNN";
        int x = 0;
        int y = 0; 
        for (int i = 0; i < dir.length(); i++) {
            if(dir.charAt(i)=='N'){
                y++;
            }
            else if(dir.charAt(i)=='E'){
                x++;
            }
            else if(dir.charAt(i)=='W'){
                x--;
            }
            else{
                y--;
            }
        }
        double ans = Math.sqrt((x*x)+(y*y));
        System.out.println(ans);
    }
}
