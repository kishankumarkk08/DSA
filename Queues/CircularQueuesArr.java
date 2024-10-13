package Queues;

public class CircularQueuesArr {

  static class QueuesCir {
    static int arr[];
    static int size;
    static int rear;
    static int front;

    QueuesCir(int n) {
      arr = new int[n];
      size = n;
      rear = -1;
      front = -1;
    }

    public static boolean isEmpty() {
      return rear == -1 && front == -1;
    }

    // full
    public static boolean isFull() {
      return (rear + 1) % size == front;
    }

    // add
    public static void add(int data) {
      if (isFull()) {
        System.out.println("Queue is full");
      }
      if (front == -1) {
        front = 0;
      }
      rear = (rear + 1) % size;
      arr[rear] = data;
    }

    // remove
    public static int remove() {
      if (isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
      }
      int result = arr[front];
      if (front == rear) {
        rear = front = -1;
      } else {
        front = (front + 1) % size;
      }
      return result;
    }

    // peek
    public static int peek() {
      if (isEmpty()) {
        return -1;
      }
      return arr[front];
    }

  }

  public static void main(String[] args) {

  }
}