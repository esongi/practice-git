package studying;

import java.util.Scanner;

public class GcdMain {

  public static void main(String[] args) {

    Gcd gcd = new Gcd();
    Scanner sc = new Scanner(System.in);

    System.out.print("첫번째 정수를 입력하세요: ");
    int x = Integer.parseInt(sc.nextLine());
    System.out.print("두번째 정수를 입력하세요: ");
    int y = Integer.parseInt(sc.nextLine());

    int gcd_num = gcd.calc(x, y);

    System.out.println("최대공약수는 " + gcd_num + "입니다");
    System.out.println("최대공배수는 " + (x * y) / gcd_num + "입니다");
    sc.close();
  }

}
