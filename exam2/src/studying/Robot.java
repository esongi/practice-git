package studying;

import java.util.Scanner;

public class Robot {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("로봇이 걸어갈 거리르 입력해주세요 >> ");
    int n = Integer.parseInt(sc.nextLine());
    System.out.println("경우의 수 " + walk(n) + "개");

    sc.close();
  }

  static int walk(int n) {
    return recursive(n, 1, 2);
  }

  // 재귀함수 단점 보완
  static int recursive(int num, int before, int next) {
    if (num == 1) {
      return before;
    } else {
      return recursive(num - 1, next, next + before);
    }
  }

}
