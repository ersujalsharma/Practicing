package Arrays;

public class LinearSearch {
    public static int LinearSearch(int[] arr,int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int number[] = {2,4,6,8,10,12,14,16};
        System.out.println(
                LinearSearch(number,17)
                );
    }
}
