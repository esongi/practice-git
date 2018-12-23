package studying;

public class ArrTest {

  public static void main(String[] args) {
    int[] array1 = {3, 4, 2, 5, 1};
    int[] array2 = {3, 4, 2, 5, 1};
    Arr arr = new Arr();

    System.out.println("선택정렬입니다:");
    arr.select(array1);
    System.out.println();
    System.out.println("버블정렬입니다:");
    arr.bubble(array2);
  }

}
