package Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int arr[] = {1,2,6,3,5};
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for(int i:arr){
            largest = largest>i ? largest : i;
            smallest = smallest<i ? smallest : i;
        }
        System.out.println(largest);
        System.out.println(smallest);
    }
}
