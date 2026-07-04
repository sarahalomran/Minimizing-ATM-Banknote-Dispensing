
package greedy;


import java.util.*;

public class Greedy {

    static int[] coins = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) {

        System.out.println("Banknotes: " + greedy(999));
    }

    public static List<Integer> greedy(int amount) {

        List<Integer> result = new ArrayList<>();

        for (int coin : coins) {

            while (amount >= coin) {
                amount -= coin;
                result.add(coin);
            }
        }

        return result;
    }
}
