package BinarySearchTree;

public class DeleteNode {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
    }
  }

  public static Node inOrderSuccessor(Node root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }

  public static Node delete(Node root, int val) {
    if (root.data > val) {
      root.left = delete(root.left, val);
    } else if (root.data < val) {
      root.right = delete(root.right, val);
    } else {
      // case 1: For leaf node
      if (root.left == null && root.right == null) {
        return null;
      }

      // case 2: For node with single children
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }

      // case 3: node with two children
      Node IS = inOrderSuccessor(root.right);
      root.data = IS.data;
      root.right = delete(root.right, IS.data);
    }
    return root;
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
  }
}
