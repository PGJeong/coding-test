package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1210 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 총 10개의 테스트 케이스
		for(int t = 0; t < 10; t++) {
			// 테스트 케이스 읽어오기
			int tcNo = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
			int[][] map = new int[100][100];
			int[] p = null; // 도착점 좌표
			
			for(int r = 0; r < 100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < 100; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] == 2) p = new int[] {r, c};
				}
			}
			
			// 도착점에서 시작하여 출발점 탐색
			while(p[0] > 0) { // 출발선(0행)에 도착할 때 까지
				// 좌측으로 길이 있는 경우
				if(p[1]-1 >= 0 && map[p[0]][p[1]-1] == 1) {
					while(p[1]-1 >= 0 && map[p[0]][p[1]-1] == 1) p[1]--;
				}		
				// 우측으로 길이 있는 경우
				else if(p[1]+1 < 100 && map[p[0]][p[1]+1] == 1) {
					while(p[1]+1 < 100 && map[p[0]][p[1]+1] == 1) p[1]++;
				}			
				// 위로 이동
				p[0]--;
			}
			
			System.out.println("#" + tcNo + " " + p[1]);
		}
	}
}
