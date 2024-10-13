package Interview;

public class avgEven {

  public static int printAvg(int arr[]) {
    int count = 0;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (i == 0 || i % 2 == 0) {
        sum += arr[i];
        count++;
      }
    }
    return sum / count;
  }

  public static void main(String[] args) {
    int[] arr = { 3, 6, 1, 5, 4 };
    System.out.println(printAvg(arr));
  }
}
