package com.bitcamp.day5;

public class TestStack {

  public static void main(String[] args) {
    MyStack myStack = new MyStack();

    for (int i = 0; i < 10; i++) {
      myStack.push(5);
    }
    myStack.push("233");

    for (int j = 0; j < 10; j++) {
      myStack.pop();
    }

    myStack.pop();
  }
}
