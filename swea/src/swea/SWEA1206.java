package swea;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA1206 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// 총 10개의 테스트 케이스
		for(int i = 1; i <= 10; i++) {
			int n = Integer.parseInt(sc.nextLine()); // 건물의 개수
			int b[] = new int[n]; // 건물의 높이
			int cnt = 0; // 조망권이 확보된 세대 수
			
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			for(int j = 0; j < n; j++)
				b[j] = Integer.parseInt(st.nextToken());
			
			// 맨 왼쪽 두 칸과 맨 오른쪽 두 칸에 있는 건물 제외
			for(int j = 2; j < n-2; j++) {
				// 양쪽 거리 2칸 이내 건물 중 최대 높이
				int max = 0;
				if(b[j-2] > max) max = b[j-2];
				if(b[j-1] > max) max = b[j-1];
				if(b[j+2] > max) max = b[j+2];
				if(b[j+1] > max) max = b[j+1];
				
				// 현재 건물(j)에서 조망권이 확보된 세대 수
				if(b[j]-max > 0) cnt += b[j]-max;
			}
			
			System.out.println("#" + i + " " + cnt);
		}
		
		sc.close();
	}
}
