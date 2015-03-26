public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        } 
        
        int totalProfit = 0;
        int curProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            curProfit = prices[i + 1] - prices[i];
            if (curProfit > 0) {
                totalProfit += curProfit;
            }
        }
        return totalProfit;
    }
}
