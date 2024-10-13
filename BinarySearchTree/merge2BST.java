package BinarySearchTree;

import java.util.*;

public class merge2BST {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
    }
  }

  // To get the inorder traversed ArrayList
  public static void inOrder(Node root, ArrayList<Integer> res) {
    if (root == null) {
      return;
    }
    inOrder(root.left, res);
    res.add(root.data);
    inOrder(root.right, res);
  }

  // To build the BST from final ArrayList
  public static Node buildBST(ArrayList<Integer> res, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    Node root = new Node(res.get(mid));
    root.left = buildBST(res, start, mid - 1);
    root.right = buildBST(res, mid + 1, end);
    return root;
  }

  public static Node merge2BST(Node root1, Node root2) {
    // first ArrayList
    ArrayList<Integer> res1 = new ArrayList<>();
    inOrder(root1, res1);

    // second ArrayList
    ArrayList<Integer> res2 = new ArrayList<>();
    inOrder(root2, res2);

    // Merged ArrayList
    int i = 0, j = 0;
    ArrayList<Integer> res = new ArrayList<>();
    while (i < res1.size() && j < res2.size()) {
      if (res1.get(i) < res2.get(j)) {
        res.add(res1.get(i));
        i++;
      } else {
        res.add(res2.get(j));
        j++;
      }

    }
    while (i < res1.size()) {
      res.add(res1.get(i));
      i++;
    }
    while (j < res2.size()) {
      res.add(res2.get(j));
    }

    // Creating BST from final ArrayList
    return buildBST(res, 0, res.size() - 1);
  }

  // Print the merged BST
  public static void preOrder(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  public static void main(String[] args) {
    Node root1 = new Node(2);
    root1.left = new Node(1);
    root1.right = new Node(4);

    Node root2 = new Node(9);
    root2.left = new Node(3);
    root2.right = new Node(12);

    Node root = merge2BST(root1, root2);
    preOrder(root);
  }
}
