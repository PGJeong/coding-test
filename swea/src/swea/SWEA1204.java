package swea;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA1204 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine()); // 테스트 케이스 수
		StringBuilder res = new StringBuilder(); // 출력값
		
		for(int i = 0; i < T; i++) {
			int tcNo = Integer.parseInt(sc.nextLine()); // 테스트 케이스 번호
			int cnt[] = new int[101]; // 각 점수의 빈도
			
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			for(int j = 0; j < 1000; j++) {
				cnt[Integer.parseInt(st.nextToken())]++;
			}
			
			int index = 0; // 죄빈값
			for(int j = 0; j < cnt.length; j++) {
				// 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력
				if(cnt[j] >= cnt[index]) index = j;
			}
			
			res.append("#" + tcNo + " " + index + "\n");
		}
		
		System.out.println(res);
		sc.close();
	}
}
