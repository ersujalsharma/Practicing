package Arrays;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
        int max =0;
        int min =Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int j2 = i; j2 <=j; j2++) {
                    sum+=arr[j2];
                }
                max = max>sum?max:sum;
                min = min<sum?min:sum;
            }
        }
        
        System.out.println(max+" "+min);
    }
}
