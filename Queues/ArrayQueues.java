package Queues;

public class ArrayQueues {

  static class Queues {
    static int arr[];
    static int size;
    static int rear;

    Queues(int n) {
      arr = new int[n];
      size = n;
      rear = -1;
    }

    public static boolean isEmpty() {
      return rear == -1;
    }

    // add
    public static void add(int data) {
      if (rear == size - 1) {
        return;
      }
      rear++;
      arr[rear] = data;
    }

    // remove
    public static int remove() {
      if (isEmpty()) {
        System.out.println("Queue is Empty");
        return -1;
      }
      int front = arr[0];
      for (int i = 0; i < rear; i++) {
        arr[i] = arr[i + 1];
      }
      rear--;
      return front;
    }

    // peek
    public static int peek() {
      if (isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
      }
      int front = arr[0];
      return front;
    }
  }

  public static void main(String[] args) {
    Queues q = new Queues(5);
    q.add(0);
    q.add(1);
    q.add(2);
    q.add(3);

    while (!q.isEmpty()) {
      System.out.println(q.peek());
      q.remove();
    }
  }
}