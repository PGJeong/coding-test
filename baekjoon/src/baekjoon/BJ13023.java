package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ13023 {
	private static int n; // ����� ��
	private static int m; // ģ�� ������ ��
	private static ArrayList<Integer> friends[];
	private static boolean visit[];
	private static boolean isExist;
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n+1];
		
		// friends �迭����
		friends = new ArrayList[n+1];
		
		for(int i = 0; i < friends.length; i++) {
			friends[i] = new ArrayList<Integer>();
		}
		
		// friends �� ����
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friends[a].add(b);
			friends[b].add(a);
		}
	}
	
	private static void dfs(int no, int cnt) {
		if(cnt == 5) {
			isExist = true;
			return;
		}
		
		visit[no] = true;
		
		for(int i = 0; i < friends[no].size(); i++) {
			int f = friends[no].get(i);
			
			if(visit[f] == false)
				dfs(f, cnt+1);
		}
		
		visit[no] = false;
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		for(int i = 1; i <= n; i++) {
			// ���� ��� ã���� �߰�Ž�� �ʿ� X
			if(isExist)
				break;
			
			 dfs(i, 1);
		}
		
		System.out.println(isExist ? 1 : 0);
	}
}
