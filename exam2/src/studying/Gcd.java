package studying;

public class Gcd {
  // 유클리드 호제법
  // 정수 a,b에 대해서 a>b일때, a=bq+r이라 하면
  // gcd(a,b) = gcd(b,r)이다. (단 0<=r<b)
  int calc(int a, int b) {
    if (b == 0) {
      return a;
    }
    return calc(b, a % b);
  }
}
