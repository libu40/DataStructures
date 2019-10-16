package com.io.test;

import java.util.Stack;

public class Stacks {

  int size;
  int[] array;
  int top;

  public Stacks(int size) {
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
    String balancedParenthesisExpr = new String("{()}[{}]");
    Stacks stack = new Stacks(5);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.peek();
    stack.pop();
    if (isParenthesisBalanced(balancedParenthesisExpr)) {
      System.out.println("The parenthesis are balanced");
    } else {
      System.out.println("The parenthesis are NOT balanced");
    }
    reverseString("Libu");
  }

  private static boolean isParenthesisBalanced(String expression) {
    String stringToReverse = "Libu";
    Stack<Character> balancedParenthesisCheck = new Stack();

    for (int i = 0; i < expression.length(); i++) {
      if (expression.charAt(i) == '{' || expression.charAt(i) == '['
          || expression.charAt(i) == '(') {
        balancedParenthesisCheck.push(expression.charAt(i));
      }
      if (expression.charAt(i) == '}' || expression.charAt(i) == ']'
          || expression.charAt(i) == ')') {
        if (balancedParenthesisCheck.isEmpty()) {
          return false;
        } else {
          Character top = balancedParenthesisCheck.pop();
          if ((top == '(' && expression.charAt(i) != ')') || (top == '{'
              && expression.charAt(i) != '}')
              || (top == '[' && expression.charAt(i) != ']')) {
            return false;
          }
        }
      }
    }

    return balancedParenthesisCheck.isEmpty();
  }

  private static char[] reverseString(String stringToReverse) {
    Stack<Character> reversedStringStack = new Stack<>();
    char[] c = stringToReverse.toCharArray();
    for (int i = 0; i < stringToReverse.length(); i++) {
      reversedStringStack.push(stringToReverse.charAt(i));
    }

    int reversedStringCounter = 0;

    while (!reversedStringStack.isEmpty()) {
      c[reversedStringCounter++] =reversedStringStack.pop();
      return c;
    }
    return c;
  }
}
