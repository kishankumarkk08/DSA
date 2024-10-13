package Interview;

public class ratfood {

  public static int isSufficient(int r, int unit, int arr[], int n) {
    if (n == 0) {
      return -1;
    }
    int foodReq = r * unit;
    int foodAvl = 0;
    for (int i = 0; i < n; i++) {
      foodAvl += arr[i];
      if (foodAvl >= foodReq) {
        return i + 1;
      }
    }
    return 0;

  }

  public static void main(String[] args) {
    int[] foods = { 2, 8, 3, 5, 7, 4, 1, 2 };
    System.out.println(isSufficient(7, 2, foods, 8));
  }
}
