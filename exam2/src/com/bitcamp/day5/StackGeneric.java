package com.bitcamp.day5;

import java.util.Arrays;

public class StackGeneric<T> {

  private StackGeneric<T> stackGeneric = new StackGeneric<>();
  private int now_index = 0;
 
  public boolean empty() {
    return now_index == 0 ? true : false;
  }

  public boolean full() {
    return now_index == 10 ? true : false;
  }

  public void push(Object i) {
    if (!full()) {
      stackArr[now_index++] = i;
      System.out.println(i + "를 넣었음");
      System.out.println("현재: " + Arrays.toString(stackArr));
    } else {
      System.out.println("더 이상 넣을 수 없습니다");
    }
    
    
    
    
  }

  public Object pop() {
    if (!empty()) {
      System.out.println(stackArr[now_index - 1] + "를 뺍니다");
      stackArr[now_index - 1] = null;
      System.out.println("현재: " + Arrays.toString(stackArr));
      return now_index--;
    } else {
      System.out.println("더 이상 뺄 수 없습니다");
      return true;
    }
  }


}
