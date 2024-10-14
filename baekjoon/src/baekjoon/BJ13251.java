package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13251 {
	private static int color; // ������ ����
	private static int[] stone; // �� ������ ���൹ ����
	private static int pick; // ���� ���൹ ����
	private static int all = 0; // ��ü ���൹ ����
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		color = Integer.parseInt(br.readLine());
		stone = new int[color];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < color; i++) {
			stone[i] = Integer.parseInt(st.nextToken());
			all += stone[i];
		}
		
		pick = Integer.parseInt(br.readLine());
	}
	
	public static void main(String[] args) throws IOException {
		init();	
		double prob = 0;
		
		for(int i = 0; i < color; i++) {
			double p = 1; // ���� ���൹�� i��° ������ Ȯ��
			int c = stone[i]; // i��° ������ ���൹ ����
			int a = all; // ���� ���൹ ����
			
			for(int j = 0; j < pick; j++) {
				p *= (double)c / a;
				c--;
				a--;
			}
			
			prob += p;
		}
		
		System.out.println(prob);
	}
}
