package Arrays;

import java.util.Scanner;

public class ArraysCC {
    public static void main(String[] args) {
        int marks[] = new int[3];
        Scanner scanner = new Scanner(System.in);
        marks[0] = 1;
        marks[2] = 30;
        marks[1]  = 90;
        System.out.println(marks[0]+" "+marks[1]+" "+marks[2]);
        update(marks);
        for (int i : marks) {
            System.out.println(i);
        }
    }
    public static void update(int marks[]){
        for (int i = 0; i < marks.length; i++) {
            marks[i] +=1;
        }
    }
}
