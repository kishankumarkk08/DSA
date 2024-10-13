package Heaps;

import java.util.*;

public class NRopes {
  public static void main(String[] args) {
    int ropes[] = { 2, 3, 3, 4, 6 };
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < ropes.length; i++) {
      pq.add(ropes[i]);
    }
    int cost = 0;

    while (pq.size() > 1) {
      int rope1 = pq.remove();
      int rope2 = pq.remove();
      cost += rope1 + rope2;
      pq.add(rope1 + rope2);
    }
    System.out.println(cost);

  }
}
