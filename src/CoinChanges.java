package practice;
import java.util.ArrayList;
import java.util.List;


public class CoinChanges {

    // total number of ways to make up total using the coins with infinite supply.
    public int coinChanges(int[] coins, int total) {
        int[] opt = new int[total + 1];
        opt[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (coins[i] <= j) {
                    opt[j] += opt[j - coins[i]];
                }
            }
        }
        return opt[total];
    }
    
    // all possible combinations assuming one coin can be selected once.
    public void coinCombinations(int[] coins, int total, List<Integer> chosen, int start) {
        if (total <= 0) {
            if (total == 0) {
                System.out.println(chosen.toString());
            }
            return;
        }
        
        for (int i = start; i < coins.length; i++) {
            chosen.add(coins[i]);
            coinCombinations(coins, total - coins[i], chosen, i+1);
            chosen.remove(chosen.size() - 1);
        }
    }
    
    // all possible combinations assuming one coin can be selected more than once.
    public void coinCombinationsWithInfiniteSupply(int[] coins, int total, List<Integer> chosen, int start) {
        if (total <= 0) {
            if (total == 0) {
                System.out.println(chosen.toString());
            }
            return;
        }
        
        for (int i = start; i < coins.length; i++) {
            chosen.add(coins[i]);
            coinCombinationsWithInfiniteSupply(coins, total - coins[i], chosen, i);
            chosen.remove(chosen.size() - 1);
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] coins = new int[]{1,2,3,4,5};
        int total = 10;
        System.out.println(new CoinChanges().coinChanges(coins,total));
        System.out.println("Coin combinations with select only once:");
        new CoinChanges().coinCombinations(coins, total, new ArrayList<Integer>(), 0);
        System.out.println("Coin combinations with select inifinite times:");
        new CoinChanges().coinCombinationsWithInfiniteSupply(coins, total, new ArrayList<Integer>(), 0);
    }

}
