
package brute.force;
import java.util.*;

public class BruteForce {

    static int[] coins = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) {

        System.out.println("Banknotes: " + bruteForce(93));
    }

    public static List<Integer> bruteForce(int amount) {

        if (amount == 0)
            return new ArrayList<>();

        if (amount < 0)
            return null;

        List<Integer> best = null;

        for (int coin : coins) {

            List<Integer> result = bruteForce(amount - coin);

            if (result != null) {

                List<Integer> combination = new ArrayList<>(result);
                combination.add(coin);

                if (best == null || combination.size() < best.size())
                    best = combination;
            }
        }

        return best;
    }
}


