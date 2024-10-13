package BinaryTrees;

public class sumTree {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public static int TreeSum(Node root) {
    if (root == null) {
      return 0;
    }
    int lc = TreeSum(root.left);
    int rc = TreeSum(root.right);
    int data = root.data;
    int leftData = (root.left != null) ? root.left.data : 0;
    int rightData = (root.right != null) ? root.right.data : 0;
    root.data = leftData + lc + rightData + rc;
    return data;
  }

  public static void preOrder(Node root) {
    if (root == null) {
      return;
    }
    System.out.println(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    TreeSum(root);
    preOrder(root);
  }
}
