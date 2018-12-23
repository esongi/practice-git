package studying;

import java.util.Scanner;

public class FibonacciTest {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int number = Integer.parseInt(sc.nextLine());
    FibonacciSequence2 sequence = new FibonacciSequence2();

    System.out.println(sequence.calc(number));

    sc.close();
  }

}
