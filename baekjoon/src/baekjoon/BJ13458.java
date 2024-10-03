package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13458 {
	private static int room; // ������ ��
	private static int[] people; // �� �������� ������ ��
	private static int a; // �Ѱ������� ������ �� �ִ� ������ ��
	private static int b; // �ΰ������� ������ �� �ִ� ������ ��
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		room = Integer.parseInt(st.nextToken());
		people = new int[room];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < room; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
	}
	
	private static long solution() {
		// (��������) "������ ��", "�� �������� ������ ��"�� �ִ� 1,000,000�̹Ƿ� �ΰ������� ���� long Ÿ�Կ� �����ؾ� ��
		// �Ѱ������� ��
		long numA = room; // �Ѱ������� ������ �����忡 1��
		
		// �ΰ������� ��
		long numB = 0;
		for(int i = 0; i < room; i++) {
			if(people[i] - a > 0) // �ΰ������� �ʿ��� ��쿡�� �����ؾ� ��
				numB += (people[i] - a) / b + ((people[i] - a) % b == 0 ? 0 : 1);
		}
		
		return numA + numB;
	}
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(solution());
	}
}
