package studying;

import java.util.Random;
import java.util.Scanner;

public class Game {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      Random random = new Random();
      int random_num = random.nextInt(100);
      System.out.println("수를 결정했습니다. 맞춰보세요 0~99>>");
      int count = 0;

      while (true) {
        count++;
        System.out.print(count + ">>");
        int input = sc.nextInt();

        if (random_num == input) {
          System.out.println("정답입니다! 다시하겠습니까?(Y/N)");
          String re = sc.next();

          if ("y".equalsIgnoreCase(re)) {
            break;
          } else {
            sc.close();
            return;
          }
        } else if (random_num > input) {
          System.out.println("더 높게");
        } else {
          System.out.println("더 낮게");
        }
      }
    }

  }
}
