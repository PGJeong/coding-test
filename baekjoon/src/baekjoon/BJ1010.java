package baekjoon;

import java.util.Scanner;

public class BJ1010 {
	private static int n; // �׽�Ʈ���̽� ����
	private static int[][] tc; // �׽�Ʈ���̽�
	private static int[][] dp;
	
	private static void init() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		tc = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			tc[i][0] = sc.nextInt();
			tc[i][1] = sc.nextInt();
		}
		
		sc.close();
		
		dp = new int[30][30];
	}
	
	public static void main(String[] args) {
		init();
		
		for(int i = 0; i < dp.length; i++ ) {
			dp[i][i] = 1; // i�� �� i�� �����ϴ� ����� �� 1
			dp[i][0] = 1; // i�� �� 0�� �����ϴ� ����� �� 1
			dp[i][1] = i; // i�� �� 1�� �����ϴ� ����� �� i
		}
		
		for(int r = 3; r < dp.length; r++) {
			for(int c = 2; c < r; c++) {
				dp[r][c] = dp[r-1][c] + dp[r-1][c-1]; // ���� ��ȭ��
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(dp[tc[i][1]][tc[i][0]]);
		}
	}
}