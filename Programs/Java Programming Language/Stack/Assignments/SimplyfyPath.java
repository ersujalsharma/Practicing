package Stack.Assignments;

import java.util.Stack;

/**
 * SimplyfyPath
 */
public class SimplyfyPath {

    public static void main(String[] args) {
        String str = "/apnacollege/./..";
        String ans = simplifyPath(str);
        System.out.println(ans);

    }

    private static String simplifyPath(String str) {
        Stack<String> stack = new Stack<>(); 
        for (int i = 0; i < str.length(); i++) {
            String dir = "";
            while(str.charAt(i)=='/') i++;
            while(i<str.length() && str.charAt(i)!='/') {
                dir +=str.charAt(i);
                i++;
            }
            if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if(dir == "."){
                continue;
            }
            else if(dir.length()!=0){
                stack.push(dir);
            }
        }
        String ans = "/";
        while(!stack.isEmpty()){
            if(stack.size()!=1){
                ans+=(stack.pop()+'/');
            }
            else{
                ans+=stack.pop();
            }
        }
        return ans;
    }
}