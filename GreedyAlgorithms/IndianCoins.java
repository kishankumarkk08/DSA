package GreedyAlgorithms;

import java.util.*;

public class IndianCoins {

  public static void main(String[] args) {
    Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };

    Arrays.sort(coins, Comparator.reverseOrder());

    int coinsCount = 0;
    int money = 590;

    for (int i = 0; i < coins.length; i++) {
      if (coins[i] <= money) {
        while (coins[i] <= money) {
          coinsCount++;
          money -= coins[i];
        }
      }
    }
    System.out.println(coinsCount);
  }
}