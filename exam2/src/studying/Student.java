package studying;

public class Student {

  public static void main(String[] args) {
    int[] score = new int[] {79, 88, 97, 54, 56, 95};
    int max = score[0];
    int min = score[0];

    for (int i = 0; i < score.length; i++) {
      max = (max > score[i]) ? max : score[i];
      min = (min < score[i]) ? min : score[i];
    }

    System.out.println("max value = " + max);
    System.out.println("min value = " + min);

    int sum = 0;
    float average = 0f;
    int[] jumsu = {100, 55, 90, 60, 78};

    for (int num : jumsu) {
      sum += num;

      if (num == jumsu[jumsu.length - 1]) {
        average = (float) sum / jumsu.length;
      }
    }
    System.out.println("총 과목 수: " + jumsu.length);
    System.out.println("점수의 합:" + sum);
    System.out.println("점수의 평균: " + average);
  }

}
