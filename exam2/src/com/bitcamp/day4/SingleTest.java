package com.bitcamp.day4;

public class SingleTest {

  public static void main(String[] args) {

    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();

    if (s1 == s2) {
      System.out.println("이건 같습니다");
    } else {
      System.out.println("이건 같지 않음");
    }
  }

}
