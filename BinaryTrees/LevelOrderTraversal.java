package BinaryTrees;

import java.util.*;

public class LevelOrderTraversal {

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

  public static void level(Node root) {
    if (root == null) {
      return;
    }
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);

    while (!q.isEmpty()) {
      Node curr = q.poll();
      if (curr == null) {
        if (q.isEmpty()) {
          return;
        } else {
          q.offer(null);
          System.out.println();
        }
      } else {
        System.out.print(curr.data + " ");

        if (curr.left != null) {
          q.offer(curr.left);
        }
        if (curr.right != null) {
          q.offer(curr.right);
        }
      }
    }
  }

  //Largest Number in each Tree Row


  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    level(root);
  }
}