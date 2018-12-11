package com.bitcamp.day2;

public class Airplane {
	private int air_num;
	private String air_name;
	private static int air_total_count;

	public Airplane(int air_num, String air_name) {
		this.air_num = air_num;
		this.air_name = air_name;
		air_total_count++;
	}

	public void airplaneInfo() {
		System.out.printf("번호:%d, 이름:%s\n", air_num, air_name);
	}

	public void airplaneTotalCount() {
		System.out.println("총 제작 비행기수: " + air_total_count);
	}
}
