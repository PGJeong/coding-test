package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BJ11399 {
	private static Scanner sc = new Scanner(System.in);
	private static int persons;
	private static int[] waiting;
	
	public static void main(String[] args) {
		// �Է°� ����
		persons = sc.nextInt();
		
		waiting = new int[persons];
		for(int i = 0; i < persons; i++)
			waiting[i] = sc.nextInt();
		
		// ����
		Arrays.sort(waiting); // �������� ����
		
		int answer = 0;
		int temp = 0;
		for(int i = 0; i < persons; i++) {
			temp += waiting[i];
			answer += temp;
		}
		
		System.out.println(answer);
	}
}