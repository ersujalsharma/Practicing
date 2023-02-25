package GreedyAlgorithms.Assignments;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int prices[] = {7,1,5,6,4};
        int max_profit = maxPro(prices,prices.length);
        System.out.println(max_profit);
    }

    private static int maxPro(int[] prices, int length) {
        int buy = prices[0],max_profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(buy >prices[i]){
                buy = prices[i];
            }
            else if(prices[i]-buy>max_profit){
                max_profit = prices[i]-buy;
            }
        }
        return max_profit;
    }
}
