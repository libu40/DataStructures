package com.io.test;

public class Stack {

  int size;
  int[] array;
  int top;

  public Stack(int size) {
    this.size = size;
    this.array = new int[size];
    this.top = -1;
  }

  public boolean isFull() {
    return (this.size - 1 == top);
  }

  public boolean isEmpty() {
    return this.top == -1;
  }

  public void push(int element) {
    if (!isFull()) {
      top++;
      array[top] = element;
    }
  }

  public int pop() {
    if (!isEmpty()) {
      int poppedElement = top;
      top--;
      System.out.println(" the popped element is" + array[poppedElement]);
      return array[poppedElement];
    }
    return -1;
  }

  public int peek() {
    if (!isEmpty()) {
      System.out.println(" the peeked element is" + array[top]);
      return array[top];
    }
    return -1;
  }

  public static void main(String[] args) {
    Stack stack = new Stack(5);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.peek();
    stack.pop();
  }
}
