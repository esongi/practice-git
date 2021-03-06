package com.bitcamp.day6;

import java.util.Random;
import java.util.Scanner;

public class StairsGame {

  public static void main(String[] args) {
    String[] list = {"가위", "바위", "보"};
    int my_goal = 0;
    int com_goal = 0;

    while (true) {
      // 게임 설정
      System.out.print("몇 계단으로 하시겠습니까: ");
      Scanner sc = new Scanner(System.in);
      int goal_stairs = Integer.parseInt(sc.nextLine());

      // 게임 시작
      while (true) {

        System.out.print("가위,바위,보 를 입력해주세요: ");
        String my_submit = sc.nextLine();

        Random random = new Random();
        int com_submit = random.nextInt(list.length);

        if (my_submit.equals("가위") && list[com_submit].equals("보")) {
          System.out.println("이겼습니다!");
          my_goal += 2;
        } else if (my_submit.equals("바위") && list[com_submit].equals("가위")) {
          System.out.println("이겼습니다!");
          my_goal += 3;
        } else if (my_submit.equals("보") && list[com_submit].equals("바위")) {
          System.out.println("이겼습니다!");
          my_goal += 5;
        } else if (my_submit.equals("보") && list[com_submit].equals("가위")) {
          System.out.println("졌습니다!");
          com_goal += 2;
        } else if (my_submit.equals("가위") && list[com_submit].equals("바위")) {
          System.out.println("졌습니다!");
          com_goal += 3;
        } else if (my_submit.equals("바위") && list[com_submit].equals("보")) {
          System.out.println("졌습니다!");
          com_goal += 5;
        } else {
          System.out.println("비겼습니다!");
        }
        System.out.println("현재 나의 위치: " + my_goal + "계단");
        System.out.println("컴퓨터의 위치: " + com_goal + "계단");

        if (my_goal >= goal_stairs || com_goal >= goal_stairs) {
          if (my_goal >= goal_stairs) {
            System.out.print("당신이 이겼습니다! 다시 하시겠습니까?(Y/N)");
          } else if (com_goal >= goal_stairs) {
            System.out.print("컴퓨터가 이겼습니다! 다시 하시겠습니까?(Y/N)");
          }
          my_goal = 0;
          com_goal = 0;

          if (sc.nextLine().equalsIgnoreCase("n")) {
            sc.close();
            System.exit(0);
          } else {
            System.out.print("몇 계단으로 하시겠습니까: ");
            goal_stairs = Integer.parseInt(sc.nextLine());
            continue;
          }
        }
      }

    }
  }
}
