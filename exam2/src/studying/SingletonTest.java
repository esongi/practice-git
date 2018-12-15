package studying;

public class SingletonTest {

  public static void main(String[] args) {

    // 생성자를 private 접근제어자를 사용했기 때문에 new를 사용 못함
    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();

    if (s1 == s2) {
      System.out.println("이건 같음");
    }
    System.out.println(s1);
    System.out.println(s2);
  }

}
