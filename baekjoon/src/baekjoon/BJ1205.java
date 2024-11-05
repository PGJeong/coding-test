package baekjoon;

import java.util.Scanner;

public class BJ1205 {
	private static int size; // list size
	private static int[] list;
	private static int score; // �¼� ����
	
	private static void init() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // list�� ����ִ� ���� ����
		score = sc.nextInt();
		size = sc.nextInt();
		list = new int[size];
		
		for(int i = 0; i < size; i++)
			list[i] = -1;
					
		for(int i = 0; i < n; i++)
			list[i] = sc.nextInt();
		
		sc.close();
	}
	
	public static void main(String[] args) {
		init();
		int rank = 1; // ���
		int same = 0; // ������
		
		for(int i = 0; i < size; i++) {
			if(list[i] > score) rank++;
			else if(list[i] == score) same++;
			else break;
		}
		
		if(rank + same > size) System.out.println(-1);
		else System.out.println(rank);
	}
}
