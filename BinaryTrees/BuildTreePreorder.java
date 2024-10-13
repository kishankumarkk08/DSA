package BinaryTrees;

import java.util.*;

public class BuildTreePreorder {

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

  static class BinaryTree {
    static int idx = -1;

    public static Node buildTree(int nodes[]) {
      idx++;
      if (nodes[idx] == -1) {
        return null;
      }
      Node newNode = new Node(nodes[idx]);
      newNode.left = buildTree(nodes);
      newNode.right = buildTree(nodes);

      return newNode;
    }

    // preOrder Traversal
    public static void printPreorder(Node root) {
      if (root == null) {
        return;
      }
      System.out.println(root.data + " ");
      printPreorder(root.left);
      printPreorder(root.right);
    }

    // inorder traversal
    public static void inOrderTraversal(Node root) {
      if (root == null) {
        return;
      }
      inOrderTraversal(root.left);
      System.out.print(root.data + " ");
      inOrderTraversal(root.right);
    }

    // postOrder traversal
    public static void postOrderTraversal(Node root) {
      if (root == null) {
        return;
      }
      postOrderTraversal(root.left);
      postOrderTraversal(root.right);
      System.out.print(root.data + " ");
    }

    // level order traversal
    public static void levelOrderTraversal(Node root) {
      if (root == null) {
        return;
      }
      Queue<Node> q = new LinkedList<>();
      q.add(root);
      q.add(null);
      while (!q.isEmpty()) {
        Node currNode = q.remove();
        if (currNode == null) {
          System.out.println();
          if (q.isEmpty()) {
            break;
          } else
            q.add(null);
        } else {
          System.out.print(currNode.data + " ");
          if (currNode.left != null) {
            q.add(currNode.left);
          }
          if (currNode.right != null) {
            q.add(currNode.right);
          }
        }
      }
    }

    // Height of a Tree
    public static int Height(Node root) {
      if (root == null) {
        return 0;
      }
      int lh = Height(root.left);
      int rh = Height(root.right);
      int height = Math.max(lh, rh) + 1;
      return height;
    }

    // Count of Nodes
    public static int countNodes(Node root) {
      if (root == null) {
        return 0;
      }
      int Lcount = countNodes(root.left);
      int Rcount = countNodes(root.right);
      int totalCount = Lcount + Rcount + 1;
      return totalCount;
    }

    // Diameter of Tree (Approach 1)
    public static int Diameter(Node root) {
      if (root == null) {
        return 0;
      }
      int ld = Diameter(root.left);
      int lh = Height(root.left);
      int rd = Diameter(root.right);
      int rh = Height(root.right);
      return Math.max(lh + rh + 1, Math.max(ld, rd));
    }

    // Sum of Nodes
    public static int Sum(Node root) {
      if (root == null) {
        return 0;
      }
      int Lsum = Sum(root.left);
      int Rsum = Sum(root.right);
      return Lsum + Rsum + root.data;
    }
  }

  public static void main(String[] args) {
    int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

    BinaryTree tree = new BinaryTree();
    Node root = tree.buildTree(nodes);
    // System.out.println(root.data);
    // tree.printPreorder(root);
    // tree.inOrderTraversal(root);
    // System.out.println();
    // tree.postOrderTraversal(root);
    // tree.levelOrderTraversal(root);
    // System.out.println(tree.Height(root));
    System.out.println(tree.Diameter(root));

  }
}
