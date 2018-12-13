package com.bitcamp.day3;

import java.util.Scanner;

public class NumberTest {

  public static void main(String[] args) {
    int num = (int) ((Math.random()) * 99);

    int tryCount = 1;
    Scanner sc = new Scanner(System.in);
    System.out.println("0 ~ 99 사이의 숫자를 입력하세요  ");

    while (true) {
      System.out.println(num);
      System.out.println(tryCount + ">>");

      int answer = Integer.parseInt(sc.nextLine());

      if (answer > num) {
        System.out.println("값이 더 낮습니다");
      } else if (answer < num) {
        System.out.println("값이 더 높습니다");
      }
      if (answer == num) {
        System.out.print("정답입니다. 다시 하겠습니까? (y/n) ");

        if (sc.nextLine().equals("y")) {
          tryCount = 1;
          // 랜덤정수 새로 저장
          num = (int) ((Math.random()) * 99);
          continue;
        } else if (sc.nextLine().equals("n")) {
          System.out.println("종료합니다");
          break;
        }
      }
      tryCount++;
    }
    sc.close();
  }
}
