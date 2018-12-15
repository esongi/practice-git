package studying;

public enum SingletonEnum {

  // enum을 싱글톤 패턴으로 사용할 수 있는 이유
  // INSTANCE가 생성될 때, multi thread로부터 안전(추가된 메소드들은 safe안할 수도 있다)
  // 단 한번의 인스턴스 생성을 보장
  // 사용이 간편
  // enum value는 자바 프로그램 전역에서 접근이 가능
  // copy of light <java effective>
  INSTANCE;
  static String test = "";

  public static SingletonEnum getInstance() {
    test = "test";
    return INSTANCE;
  }
}
