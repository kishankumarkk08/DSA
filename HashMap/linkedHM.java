package HashMap;

import java.util.*;

import java.util.LinkedHashMap;

public class linkedHM {
  // keys are insertion ordered
  public static void main(String[] args) {
    LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
    lhm.put("IND", 100);
    lhm.put("CHN", 80);
    lhm.put("US", 50);

    HashMap<String, Integer> map = new HashMap<>();
    map.put("IND", 100);
    map.put("CHN", 80);
    map.put("US", 50);

    System.out.println(lhm);
    System.out.println(map);
  }
}
