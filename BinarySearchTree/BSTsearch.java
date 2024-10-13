package BinarySearchTree;

public class BSTsearch {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
    }
  }

  public static boolean search(Node root, int val) {
    if (root == null) {
      return false;
    }
    if (root.data == val) {
      return true;
    }
    if (val < root.data) {
      return search(root.left, val);
    } else if (val > root.data) {
      return search(root.right, val);
    }
    return false;

  }

  public static void main(String[] args) {
    Node root = new Node(4);
    root.left = new Node(2);
    root.right = new Node(5);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.right = new Node(6);

    System.out.println(search(root, 6));
  }
}

// Time Complexity = O(H)~O(logN) -> Best Case // O(N) -> Worst Case
