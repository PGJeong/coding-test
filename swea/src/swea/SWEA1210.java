package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1210 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �� 10���� �׽�Ʈ ���̽�
		for(int t = 0; t < 10; t++) {
			// �׽�Ʈ ���̽� �о����
			int tcNo = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽� ��ȣ
			int[][] map = new int[100][100];
			int[] p = null; // ������ ��ǥ
			
			for(int r = 0; r < 100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < 100; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] == 2) p = new int[] {r, c};
				}
			}
			
			// ���������� �����Ͽ� ����� Ž��
			while(p[0] > 0) { // ��߼�(0��)�� ������ �� ����
				// �������� ���� �ִ� ���
				if(p[1]-1 >= 0 && map[p[0]][p[1]-1] == 1) {
					while(p[1]-1 >= 0 && map[p[0]][p[1]-1] == 1) p[1]--;
				}		
				// �������� ���� �ִ� ���
				else if(p[1]+1 < 100 && map[p[0]][p[1]+1] == 1) {
					while(p[1]+1 < 100 && map[p[0]][p[1]+1] == 1) p[1]++;
				}			
				// ���� �̵�
				p[0]--;
			}
			
			System.out.println("#" + tcNo + " " + p[1]);
		}
	}
}
