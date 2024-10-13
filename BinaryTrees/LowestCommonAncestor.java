package BinaryTrees;

import java.util.ArrayList;

public class LowestCommonAncestor {

  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  // Approach 1
  public static boolean getPath(Node root, int n, ArrayList<Node> path) {
    if (root == null) {
      return false;
    }
    path.add(root);
    if (root.data == n) {
      return true;
    }

    boolean foundLeft = getPath(root.left, n, path);
    boolean foundRight = getPath(root.right, n, path);

    if (foundLeft || foundRight) {
      return true;
    }
    path.remove(path.size() - 1);
    return false;
  }

  public static Node lca(Node root, int n1, int n2) {
    ArrayList<Node> path1 = new ArrayList<>();
    ArrayList<Node> path2 = new ArrayList<>();

    getPath(root, n1, path1);
    getPath(root, n2, path2);
    int i = 0;
    for (; i < path1.size() && i < path2.size(); i++) {
      if (path1.get(i) != path2.get(i)) {
        break;
      }
    }
    Node lca = path1.get(i - 1);
    return lca;
  }

  // Approach 2
  public static Node lca2(Node root, int n1, int n2) {
    if (root == null || root.data == n1 || root.data == n2) {
      return root;
    }

    Node leftLCA = lca2(root.left, n1, n2);
    Node rightLCA = lca2(root.right, n1, n2);

    if (rightLCA == null) {
      return leftLCA;
    }
    if (leftLCA == null) {
      return rightLCA;
    }
    return root;
  }

  // Min Dist between 2 nodes
  public static int lcaDist(Node root, int n) {
    if (root == null) {
      return -1;
    }
    if (root.data == n) {
      return 0;
    }
    int leftDist = lcaDist(root.left, n);
    int rightDist = lcaDist(root.right, n);

    if (leftDist == -1 && rightDist == -1) {
      return -1;
    } else {
      if (leftDist == -1) {
        return rightDist + 1;
      } else
        return leftDist + 1;
    }
  }

  public static int minDist(Node root, int n1, int n2) {
    Node lca = lca2(root, n1, n2);

    return lcaDist(lca, n1) + lcaDist(lca, n2);
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    int n1 = 4;
    int n2 = 5;

    // System.out.println(lca2(root, n1, n2).data);
    System.out.println(minDist(root, n1, n2));

  }
}
