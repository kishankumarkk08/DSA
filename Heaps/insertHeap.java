package Heaps;

import java.util.*;

public class insertHeap {
  static class Heap {
    ArrayList<Integer> res = new ArrayList<>();

    // Add
    public void add(int data) {
      res.add(data);

      int child = res.size() - 1;
      int parent = (child - 1) / 2;

      while (res.get(child) < res.get(parent)) {
        int temp = res.get(child);
        res.set(child, res.get(parent));
        res.set(parent, temp);

        child = parent;
        parent = (child - 1) / 2;
      }
    }

    // Peek
    public int peek() {
      return res.get(0);
    }

    // heapify
    private void heapify(int i) {
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      int minIdx = i;

      if (left < res.size() && res.get(minIdx) > res.get(left)) {
        minIdx = left;
      }
      if (right < res.size() && res.get(minIdx) > res.get(right)) {
        minIdx = right;
      }
      if (minIdx != i) {
        // swap
        int temp = res.get(i);
        res.set(i, res.get(minIdx));
        res.set(minIdx, temp);

        heapify(minIdx);
      }
    }

    // Remove
    public int remove() {
      int data = res.get(0);

      // swapping first and last index
      int temp = res.get(0);
      res.set(0, res.get(res.size() - 1));
      res.set(res.size() - 1, temp);

      // deleting the last idx;
      res.remove(res.size() - 1);

      heapify(0);
      return data;
    }

    public boolean isEmpty() {
      return res.size() == 0;
    }
  }

  public static void main(String[] args) {

  }
}
