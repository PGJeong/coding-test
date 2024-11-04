package baekjoon;

import java.util.Scanner;

public class BJ9655 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // �־��� ���� ����
		boolean[] DP = new boolean[1001]; // DP[n] : �־��� ���� n���� �� ���� (���: true, â��: false)
		
		// DP �迭 �ʱ갪
		DP[1] = true;
		DP[2] = false;
		DP[3] = true;
		
		// DP ��ȭ�� : DP[i] = !DP[i-1]
		for(int i = 4; i <= n; i++) {
			DP[i] = !DP[i-1];
		}
		
		if(DP[n]) System.out.println("SK");
		else System.out.println("CY");
		
		sc.close();
	}
}
