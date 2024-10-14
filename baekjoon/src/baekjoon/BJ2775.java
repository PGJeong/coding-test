package baekjoon;

import java.util.Scanner;

public class BJ2775 {
	private static int n; // testCase�� ��
	private static int[][] testCase;
	private static int[][] apt; // ����Ʈ
	
	private static void init() {
		Scanner sc = new Scanner(System.in);	
		n = sc.nextInt();
		testCase = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			testCase[i][0] = sc.nextInt();
			testCase[i][1] = sc.nextInt() - 1; // ȣ���� 1���� ����
		}
		sc.close();
		
		apt = new int[15][15];
		
		for(int i = 0; i < apt.length; i++) {
			apt[0][i] = i + 1; // 0���� iȣ���� i���� ��� (ȣ���� 1���� ����)
			apt[i][0] = 1; // 1ȣ���� ������ 1���� ���
		}
	}
	
	public static void main(String[] args) {
		init();
		
		for(int r = 1; r < apt.length; r++) {
			for(int c = 1; c < apt.length; c++) {
				apt[r][c] = apt[r][c-1] + apt[r-1][c];
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(apt[testCase[i][0]][testCase[i][1]]);
		}
	}
}
