package GreedyAlgorithms;

public class test {
  public static void main(String[] args) {
    String str = "/home//foo/";
    String[] myArr = str.split("/");
    for (int i = 0; i < myArr.length; i++) {
      System.out.print(myArr[i]);
    }
  }
}
