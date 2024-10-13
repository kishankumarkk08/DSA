package Queues;

public class QueuesLL {
  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  static class Queue {
    static Node head = null;
    static Node tail = null;

    public static boolean isEmpty() {
      return head == null && tail == null;
    }

    // add
    public static void add(int data) {
      Node newNode = new Node(data);
      if (head == null) {
        head = tail = newNode;
      }
      tail.next = newNode;
      tail = newNode;
    }

    // remove
    public static int remove() {
      if (isEmpty()) {
        return -1;
      }
      if (head == tail) {
        head = tail = null;
      } else {
        head = head.next;
      }
      return head.data;

    }

    // peek
    public static int peek() {
      if (isEmpty()) {
        return -1;
      }
      return head.data;
    }
  }

  public static void main(String[] args) {

  }
}