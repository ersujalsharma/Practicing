package Strings;

public class StringBufferLearning {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("Sujal");
        str.append(" Sharma");
        str.insert(1, 's');
        str.delete(1, 2);
        System.out.println(str);
    }
}
