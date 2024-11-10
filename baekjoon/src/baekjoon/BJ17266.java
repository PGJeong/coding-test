package baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ17266 {
	private static int len; // ���ٸ� ����
	private static int num; // ���ε� ����
	private static int[] loc; // ���ε� ��ġ
	
	private static void init() {
		Scanner sc = new Scanner(System.in);
		len = Integer.parseInt(sc.nextLine());
		num = Integer.parseInt(sc.nextLine());
		loc = new int[num];
		
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for(int i = 0; i < num; i++)
			loc[i] = Integer.parseInt(st.nextToken());
		
		sc.close();
	}
	
	// �Ű������� �־��� ���̷� ���ٸ� ������ Ŀ���ϴ���
	private static boolean isCovered(int height) {
		// ���ε��� Ŀ������
		int left = loc[0] - height, right = loc[0] + height;
		
		// (1) �켱 ���ٸ��� ���ۺκ��� Ŀ���ϴ��� Ȯ��
		if(left > 0) return false;
		
		// (2) �� ��° ���ε���� �� ƴ���� ���ٸ��� Ŀ���ϴ��� ����Ȯ��
		for(int i = 1; i < num; i++) {
			// (2-1) ���� ���ε��� ������ Ŀ����������, ���� ���ε��� ���� Ŀ�������� �����ϴ���
			if(loc[i] - height > right) return false;			
			// (2-2) ���ε��� ������ Ŀ������ ����
			right = loc[i] + height;
		}
		
		// (3) ���ٸ��� ���κ��� Ŀ���ϴ��� Ȯ��
		if(right >= len) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		init();
		
		int min = 1, max = len; // ������ ���ε��� ���� ����		
		int res = -1; // ���ε� ���� �ĺ�
		
		// �̺�Ž��
		while(min <= max) {
			int mid = (min + max) / 2;
			
			if(isCovered(mid)) {
				max = mid - 1;
				res = mid;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println(res);
	}
}
