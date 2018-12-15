package studying;

public class SingletonEachTime {

  // Initialization on demand holder idiom 기법
  // jvm의 class loader의 매커니즘과 class의 load 시점을 이용
  // 내부 class를 생성시킴으로 thread 간의 동기화 문제 해결
  // lazy initialization(최초 사용시점에만 인스턴스화) 가능
  // 모든 자바 버전과 jvm에서 사용 가능
  private SingletonEachTime() {}

  private static class Singleton {
    private static final SingletonEachTime instance = new SingletonEachTime();
  }

  public static SingletonEachTime getInstance() {
    System.out.println("create instance");
    return Singleton.instance;
  }
}
