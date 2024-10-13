package GreedyAlgorithms;

import java.util.*;

public class ActivitySelection {

  public static void main(String[] args) {
    int start[] = { 1, 3, 0, 5, 8, 5 };
    int end[] = { 2, 4, 6, 7, 9, 9 };

    // if the end time is not sorted
    int act[][] = new int[start.length][3];
    for (int i = 0; i < start.length; i++) {
      act[i][0] = i;
      act[i][1] = start[i];
      act[i][2] = end[i];
    }
    // sorting 2-D arrays
    Arrays.sort(act, Comparator.comparingDouble(o -> o[2]));

    int count = 1;
    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(act[0][0]);
    int lastEnd = act[0][2];
    for (int i = 0; i < end.length; i++) {
      if (act[i][1] >= lastEnd) {
        count++;
        ans.add(act[i][0]);
        lastEnd = act[i][2];
      }
    }
    System.out.println("Max Activity: " + count);
    for (int i = 0; i < ans.size(); i++) {
      System.out.println("A" + ans.get(i));
    }
  }
}