package studying;

public class Singleton {
  
  // 단 하나의 인스턴스만 만들도록 강제,보장
  // 불필요한 자원 낭비나 오버헤드 등을 방지
  // 자바와 데이터베이스를 연동(DAO 클래스)에 자주 사용
  private static Singleton singleton;

  // 외부에서 생성자를 호출할 때마다 인스턴스가 생성되기 때문에
  // 접근제어자를 private으로 사용
  private Singleton() {}

  public static Singleton getInstance() {
    // 처음 객체가 참조될 때 인스턴스를 딱 한번 생성할 수 있게 한다
    if (singleton == null) {
      singleton = new Singleton();
    }
    return singleton;
  }

}
