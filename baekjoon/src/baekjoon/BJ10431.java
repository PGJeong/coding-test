package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10431 {
	private static int p; // �׽�Ʈ ���̽� ��
	private static int[][] tc; // �׽�Ʈ ���̽� 
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		p = Integer.parseInt(br.readLine());
		tc = new int[p][20];
		
		for(int i = 0; i < p; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			for(int j = 0; j < 20; j++) {
				tc[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		for(int i = 0; i < p; i++) {
			int cnt = 0; // �ڷ� ������ Ƚ��
			
			for(int j = 0; j < 20; j++) {
				for(int k = 0; k < j; k++) {
					// ���� �л�(tc[i][j])���� �տ� �ִ� ��� �� Ű�� ū �л��� ����ŭ ���Ѵ�
					if(tc[i][k] > tc[i][j]) cnt++;
				}
			}
			System.out.println((i+1) + " " + cnt);
		}
	}
}
