package swea;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA1206 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// �� 10���� �׽�Ʈ ���̽�
		for(int i = 1; i <= 10; i++) {
			int n = Integer.parseInt(sc.nextLine()); // �ǹ��� ����
			int b[] = new int[n]; // �ǹ��� ����
			int cnt = 0; // �������� Ȯ���� ���� ��
			
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			for(int j = 0; j < n; j++)
				b[j] = Integer.parseInt(st.nextToken());
			
			// �� ���� �� ĭ�� �� ������ �� ĭ�� �ִ� �ǹ� ����
			for(int j = 2; j < n-2; j++) {
				// ���� �Ÿ� 2ĭ �̳� �ǹ� �� �ִ� ����
				int max = 0;
				if(b[j-2] > max) max = b[j-2];
				if(b[j-1] > max) max = b[j-1];
				if(b[j+2] > max) max = b[j+2];
				if(b[j+1] > max) max = b[j+1];
				
				// ���� �ǹ�(j)���� �������� Ȯ���� ���� ��
				if(b[j]-max > 0) cnt += b[j]-max;
			}
			
			System.out.println("#" + i + " " + cnt);
		}
		
		sc.close();
	}
}
