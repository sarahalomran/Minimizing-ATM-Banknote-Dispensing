
package dynamicprogramming;
import java.util.*;
public class DynamicProgramming {
static int[] coins = {1, 5, 10, 50, 100, 500};

    public static void main(String[] args) {

        System.out.println("Banknotes: " + dynamicProgramming(999));
    }

    public static List<Integer> dynamicProgramming(int amount) {

        int[] dp = new int[amount + 1];
        int[] chosen = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {

                    if (dp[i - coin] + 1 < dp[i]) {

                        dp[i] = dp[i - coin] + 1;
                        chosen[i] = coin;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while (amount > 0) {

            result.add(chosen[amount]);
            amount -= chosen[amount];
        }

        Collections.sort(result, Collections.reverseOrder());

        return result;
    }
    
}
