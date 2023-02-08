package Arrays;

/**
 * TrappingWaterUsingAuxillaryArrays
 */
public class TrappingWaterUsingAuxillaryArrays {

    public static void main(String[] args) {
        int arr[] = {4,2,0,6,3,2,5};
        // create auxillary arrays 
        // to get left max boundry
        // to get right max boundry
        int width = 1;
        int[] leftmaxboundry = new int[arr.length];
        int[] rightmaxboundry = new int[arr.length];
        for (int i = 0; i < leftmaxboundry.length; i++) {
            leftmaxboundry[i] = i == 0 ? arr[0] : Math.max(leftmaxboundry[i-1], arr[i]);
        }
        for (int i = rightmaxboundry.length-1; i >=0 ; i--) {
            rightmaxboundry[i] = i == rightmaxboundry.length-1 ? arr[rightmaxboundry.length-1] : Math.max(rightmaxboundry[i+1], arr[i]);
        }
        // for (int i = 0; i < leftmaxboundry.length; i++) {
        //     System.out.print(leftmaxboundry[i]+" ");
        // }
        // System.out.println();
        // for (int i = 0; i < rightmaxboundry.length; i++) {
        //     System.out.print(rightmaxboundry[i]+" ");
        // }
        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            sum+= (Math.min(leftmaxboundry[i],rightmaxboundry[i])-arr[i])*width;
        }
        System.out.println(sum);
    }
}