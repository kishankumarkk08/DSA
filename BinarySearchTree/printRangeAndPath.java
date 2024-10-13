package BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.tree.TreeNode;

public class printRangeAndPath {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
    }
  }

  // print range
  public static void print(Node root, int k1, int k2) {
    if (root == null) {
      return;
    }
    if (root.data >= k1 && root.data <= k2) {
      print(root.left, k1, k2);
      System.out.print(root.data + " ");
      print(root.right, k1, k2);
      System.out.print(root.data + " ");
    } else if (root.data < k1) {
      print(root.left, k1, k2);
    } else
      print(root.right, k1, k2);
  }

  // print Path from root to leaf
  public static void printPath(ArrayList<Integer> path) {
    for (int i = 0; i < path.size(); i++) {
      System.out.print(path.get(i) + "->");
    }
    System.out.println("null");
  }

  public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
    if (root == null) {
      return;
    }
    path.add(root.data);
    if (root.left == null & root.right == null) {
      printPath(path);
    }
    printRoot2Leaf(root.left, path);
    printRoot2Leaf(root.right, path);
    path.remove(path.size() - 1);
  }

  public static List<Integer> solve(Node root) {
    ArrayList<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    solve(root.left);
    res.add(root.data);
    solve(root.right);
    return res;
  }

  public static void main(String[] args) {
    Node root = new Node(8);
    root.left = new Node(5);
    root.right = new Node(10);
    root.left.left = new Node(3);
    root.left.right = new Node(6);
    root.left.left.left = new Node(1);
    root.left.left.right = new Node(4);
    root.right.right = new Node(11);
    root.right.right.right = new Node(14);

    // print(root, 5, 12);
    // printRoot2Leaf(root, new ArrayList<>());
    System.out.println(solve(root));
  }
}
