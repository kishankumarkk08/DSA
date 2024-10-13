package Interview;

import java.util.*;

public class SpecialNum {
  public static int specialNums(int arr[], int n, int k) {
    int sum = 0;
    int opr = 0;
    int val = 1;
    for (int i = 0; i < arr.length; i++) {
      while (opr < 4) {
        if (val % arr[i] != 0) {
          opr++;
          sum += val;
        }
        val++;
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    int[] arr = { 2, 3, 4, 5, 6 };
    System.out.println(specialNums(arr, 5, 4));
  }
}
