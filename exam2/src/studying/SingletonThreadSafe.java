package studying;

public class SingletonThreadSafe {
  private static SingletonThreadSafe singletonThreadSafe;

  private SingletonThreadSafe() {}

  public static synchronized SingletonThreadSafe getInstance() {

    // 동기화를 사용, 여러 스레드들이 동시에 접근해서 인스턴스를 생성하는 위험 없어짐
    // 하지만 수많은 스레드들이 메서드를 호출하면 높은 cost 비용으로 프로그램 성능저하 발생
    if (singletonThreadSafe == null) {
      singletonThreadSafe = new SingletonThreadSafe();
    }
    return singletonThreadSafe;
  }
}
