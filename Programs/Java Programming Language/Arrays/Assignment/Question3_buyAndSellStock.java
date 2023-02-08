package Arrays.Assignment;

public class Question3_buyAndSellStock {
    public static void main(String[] args) {
        int[] price = {7,1,5,6,4};
        int buyprice = Integer.MAX_VALUE;
        int profit=0;
        int maxProfit= Integer.MIN_VALUE;
        for(int i=0;i<price.length;i++){
            if(buyprice<price[i]){
                profit = price[i]-buyprice;
                maxProfit = Math.max(profit,maxProfit);
            }
            else{
                buyprice = price[i];
            }
        }
        System.out.println(maxProfit);
    }
}
