package baekjoon;

import java.util.Scanner;

public class BJ11050 {
	private static int n; // ���� nCm
	private static int m;
	private static int[][] dp;
	
	private static void init() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.close();
		
		dp = new int[n+1][n+1];
	}
	
	public static void main(String[] args) {
		init();
		
		// dp �迭 �ʱ�ȭ
		for(int i = 0; i <= n; i++) {
			dp[i][0] = 1; // i�� �� 0�� �̴� ����� �� = 1
			dp[i][i] = 1; // i�� �� i�� �̴� ����� �� = 1
			dp[i][1] = i; // i�� �� 1�� �̴� ����� �� = i
		}
		
		// ���� ���� �̿��Ͽ� �� ĭ ä���
		for(int r = 3; r <= n; r++) {
			for(int c = 2; c <= n; c++) {
				dp[r][c] = dp[r-1][c] + dp[r-1][c-1]; // ���� ��ȭ��
			}
		}
		
		// n�� �� m���� �����ϴ� ����� �� ���
		System.out.println(dp[n][m]);
	}
}
