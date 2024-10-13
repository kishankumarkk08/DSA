package BinarySearchTree;

public class MirrorBST {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
    }
  }

  // Mirror
  public static Node mirror(Node root) {
    if (root == null) {
      return null;
    }

    Node temp = root.left;
    root.left = root.right;
    root.right = temp;

    mirror(root.left);
    mirror(root.right);
    return root;
  }

  // Print mirrored tree
  public static void preOrder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
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
    preOrder(root);
    System.out.println();
    Node newRoot = mirror(root);
    preOrder(newRoot);
  }
}
