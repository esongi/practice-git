package studying;

public class FibonacciSequence2 {

  int calcReserve(int num, int before, int next) {
    if (num == 0) {
      return before;
    } else {
      return calcReserve(num - 1, next, next + before);
    }
  }

  int calc(int num) {
    return calcReserve(num, 0, 1);
  }



}
