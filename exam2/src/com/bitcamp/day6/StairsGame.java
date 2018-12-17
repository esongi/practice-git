package com.bitcamp.day6;

import java.util.Random;
import java.util.Scanner;

public class StairsGame {

  public static void main(String[] args) {

    String[] list = {"가위", "바위", "보"};
    // 가위 > 보
    // 보 > 바위
    // 바위 > 가위

    System.out.println("몇 계단으로 하시겠습니까: ");
    Scanner sc = new Scanner(System.in);
    int num = Integer.parseInt(sc.nextLine());

    while (true) {
      System.out.println("가위,바위,보 를 입력해주세요: ");
      String my_submit = sc.nextLine();

      Random random = new Random();
      int com_submit = random.nextInt(list.length);

      if (my_submit.equals(list[com_submit])) {
        System.out.println("비겼습니다. 다시 입력해주세요: ");
      } else if (list[com_submit] == "보") {
        System.out.println("이겼습니다");
      } else {
        System.out.println("졌습니다");
      }

      sc.close();
    }

  }
}
