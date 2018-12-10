package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	int[] array_lotto1 = new int[45];
	int[] array_lotto2 = new int[6];
	int temp_no;

	public void number() {

		// 1~45 채워넣는 배열생성
		for (int i = 0; i < array_lotto1.length; i++) {
			array_lotto1[i] = i + 1;
		}

		// 배열 섞기
		for (int i = 0; i < array_lotto1.length; i++) {
			int random_no = (int) ((Math.random()) * array_lotto1.length);
			temp_no = array_lotto1[i];
			array_lotto1[i] = array_lotto1[random_no];
			array_lotto1[random_no] = temp_no;
		}

		// 로또 갯수(6개) 뽑기
		for (int i = 0; i < array_lotto2.length; i++) {
			array_lotto2[i] = array_lotto1[i];
		}

		// 뽑은 로또 배열 정렬
		for (int i = 1; i < array_lotto2.length - 1; i++) {
			for (int j = 0; j < array_lotto2.length - i; j++) {
				// System.out.println(j + " 과 " + (j + 1) + " 을 비교");

				if (array_lotto2[j] > array_lotto2[j + 1]) {
					temp_no = array_lotto2[j + 1];
					array_lotto2[j + 1] = array_lotto2[j];
					array_lotto2[j] = temp_no;
				}
				// System.out.println((i) + "번째:" + java.util.Arrays.toString(array_lotto2));
			}
		}

		System.out.println("1.배열로또: " + Arrays.toString(array_lotto2));

		Set<Integer> set_lotto = new TreeSet<>();
		for (int i = 0; set_lotto.size() < 6; i++) {
			set_lotto.add((int) (Math.random() * 45) + 1);
		}
		System.out.println("2.set_lotto: " + set_lotto.toString());

	}

	public void writeNumber() {
		PrintWriter fileTxt = null;
		File file = new File("test.txt");

		try {
			fileTxt = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Lotto lotto = new Lotto();

		fileTxt.print(Arrays.toString(lotto.array_lotto2));

		fileTxt.close();

	}
}
