package com.bitcamp.day1;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {

	public int[] number() {
		int[] array_lotto1 = new int[45];
		int[] array_lotto2 = new int[6];
		int temp_no;

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

				if (array_lotto2[j] > array_lotto2[j + 1]) {
					temp_no = array_lotto2[j + 1];
					array_lotto2[j + 1] = array_lotto2[j];
					array_lotto2[j] = temp_no;
				}
			}
		}
		return array_lotto2;
	}

	public Set<?> setLotto() {
		Set<Integer> set_lotto = new TreeSet<>();
		for (int i = 0; set_lotto.size() < 6; i++) {
			set_lotto.add((int) (Math.random() * 45) + 1);
		}
		return set_lotto;
	}

	public void writeNumber(String input) throws Exception {
		FileWriter fw = new FileWriter("Lotto.txt");
		PrintWriter fileTxt = null;

		fileTxt = new PrintWriter(fw);
		fileTxt.print(input);
		fileTxt.flush();
		fileTxt.close();
	}

	public void writeNumber(Set<?> input) throws Exception {
		FileWriter fw = new FileWriter("Lotto.txt", true);
		PrintWriter fileTxt = null;

		fileTxt = new PrintWriter(fw);
		fileTxt.print(input);
		fileTxt.flush();
		fileTxt.close();
	}
}
