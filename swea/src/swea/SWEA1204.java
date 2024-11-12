package swea;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA1204 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine()); // �׽�Ʈ ���̽� ��
		StringBuilder res = new StringBuilder(); // ��°�
		
		for(int i = 0; i < T; i++) {
			int tcNo = Integer.parseInt(sc.nextLine()); // �׽�Ʈ ���̽� ��ȣ
			int cnt[] = new int[101]; // �� ������ ��
			
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			for(int j = 0; j < 1000; j++) {
				cnt[Integer.parseInt(st.nextToken())]++;
			}
			
			int index = 0; // �˺�
			for(int j = 0; j < cnt.length; j++) {
				// �ֺ���� ���� �� �� ������ ���� ū ������ ���
				if(cnt[j] >= cnt[index]) index = j;
			}
			
			res.append("#" + tcNo + " " + index + "\n");
		}
		
		System.out.println(res);
		sc.close();
	}
}
