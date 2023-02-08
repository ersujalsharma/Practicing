package Arrays;

public class buyAnsSellStocks {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        int buyprice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            if(buyprice<arr[i]){
                int profit = arr[i] - buyprice;
                maxProfit = Math.max(maxProfit, profit);
            }
            else{
                buyprice = arr[i];
            }
        }
        System.out.println(maxProfit);
    }
}
