package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2512 {
	private static int n; // ������ ��
	private static Integer[] req; // �����û
	private static int budget; // �����Ѿ�
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		n = Integer.parseInt(br.readLine());
		req = new Integer[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			req[i] = Integer.parseInt(st.nextToken());
		
		budget = Integer.parseInt(br.readLine());
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		// �����û �������� ����
		Arrays.sort(req, Collections.reverseOrder());
		
		// ������ ���Ѿ� ���� (min~max)
		int min = 0;
		int max = req[0];
		
		// ���Ѿ� �ĺ�
		int res = 0;
		
		// �̺�Ž��
		while(min <= max) {
			int mid = (min + max) / 2;
			
			int sum = 0; // mid���� ���Ѿ��� �� �ҿ俹��
			for(int i = 0; i < n; i++) {
				if(req[i] < mid) sum += req[i];
				else sum += mid;
			}
			
			if(sum <= budget) {
				min = mid + 1;
				res = mid;
			} else {
				max = mid - 1;
			}
		}
		
		System.out.println(res);
	}
}
