package studying;

public class SingletonTest {

  public static void main(String[] args) {

    // 생성자를 private 접근제어자를 사용했기 때문에 new를 사용 못함
    SingletonLazy s1 = SingletonLazy.getInstance();
    SingletonLazy s2 = SingletonLazy.getInstance();

    if (s1 == s2) {
      System.out.println("lazy 싱글톤 : 이건 같음");
    }
    System.out.println(s1);
    System.out.println(s2);

    int singletonEnum1 = SingletonEnum.getInstance().hashCode();
    int singletonEnum2 = SingletonEnum.getInstance().hashCode();

    System.out.println("열거형1 hashcode : " + singletonEnum1);
    System.out.println("열거형2 hashcode : " + singletonEnum2);
  }

}
