package Arrays;

public class ContinousSubArray {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int j2 = i; j2 <=j; j2++) {
                    sum+=arr[j2];
                    System.out.print(arr[j2]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
