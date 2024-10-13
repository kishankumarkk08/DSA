package HashMap;

import java.util.*;

public class operations {
  public static void main(String[] args) {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("India", 100);
    map.put("China", 80);
    map.put("USA", 50);

    // Iteration on HashMap
    Set<String> keys = map.keySet();
    System.out.println(keys);

    for (String s : keys) {
      System.out.println(s + " " + map.get(s));
    }
  }
}
