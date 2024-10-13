package Stacks;

import java.util.*;

public class pushAtBottom {
  // Push At Bottom of the stack
  public static void pushAtbottom(Stack<Integer> s, int data) {
    if (s.isEmpty()) {
      s.push(data);
      return;
    }
    int top = s.pop();
    pushAtbottom(s, data);
    s.push(top);
  }

  // Reversing a string using stack
  public static String reverseString(String str) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      s.push(str.charAt(i));
    }
    StringBuilder result = new StringBuilder();
    while (!s.isEmpty()) {
      result.append(s.pop());
    }
    return result.toString();
  }

  // Reverse a stack
  // public static void reverseStack(Stack<Integer> s) {
  // if (s.isEmpty()) {
  // return;
  // }
  // int top = s.pop();
  // reverseStack(top);
  // pushAtbottom(s, top);
  // }

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    System.out.println(reverseString("abc"));
  }
}
