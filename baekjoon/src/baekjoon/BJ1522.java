package baekjoon;

import java.util.Scanner;

public class BJ1522 {
	public static void main(String[] args) {
		// init
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		
		// (1) a�� ���� count
		int count = 0;
		for(int i = 0; i < input.length(); i++)
			if(input.charAt(i) == 'a') count++;
		
		// (2) count ũ���� ������ �� �� �ִ� b������ �ּ�
		// ���� �� �����ϴ� b�� ���� �ܺ��� a�� ��ȯ�Ͽ� ���� �� ���ڸ� ��� a�� ����
		int si = 0;		// ���� ������ �ʱⰪ
		int ei = count;	// ���� ������ �ʱⰪ
		int min = Integer.MAX_VALUE; // ���� �� b������ �ּ�
		
		// count ũ���� ��� ���� Ž��
		for(int i = 0; i < input.length(); i++) {
			int s = (si + i) % input.length(); // ���� ������
			int e = (ei + i) % input.length(); // ���� ������
			int tmp = 0; // ���� �� b����
			
			for(int j = s; j != e; j = (j+1) % input.length())
				if(input.charAt(j) == 'b') tmp++;
			
			min = Math.min(min, tmp);
		}
		
		System.out.println(min);
	}
}