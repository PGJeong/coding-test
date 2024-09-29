package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ16236 {
	private static int size;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] start; // �Ʊ��� ��ġ
	private static int lv; // �Ʊ��� ũ��
	private static int eat; // ���� ����� ��
	
	private static final int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		size = Integer.parseInt(st.nextToken());
		map = new int[size][size];
		lv = 2;
		eat = 0;
		
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// �Ʊ��� ��ġ ����
				if(map[i][j] == 9) {
					start = new int[] {i, j, 0};
					// ������ ȥ������ �ʵ��� map���� ����
					map[i][j] = 0;
				}
			}
		}
	}
	
	private static int BFS(int[] loc) {
		// loc[0] : row
		// loc[1] : col
		// loc[2] : dist (�Ʊ���κ����� �Ÿ�)
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			// PriorityQueue�� �⺻������ �ּ� �� ������, ���� ���� ���� �켱������ ó��
			// ����(-): o1�� o2���� ���� �켱����, ���(+): o1�� o2���� ���� �켱����, (0): ������ �켱����
			@Override
			public int compare(int[] o1, int[] o2) {
				// (1����) ���� ����� �����
				if(o1[2] != o2[2]) return o1[2] - o2[2];
				// (2����) ���� ���� �ִ� �����
				else if(o1[0] != o2[0]) return o1[0] - o2[0];
				// (3����) ���� ���ʿ� �ִ� �����
				else if(o1[1] != o2[1]) return o1[1] - o2[1];
				
				return 0;
			};
		});
		
		// ���۳�� ����
		q.add(loc);
		visited[loc[0]][loc[1]] = true;
		
		while(!q.isEmpty()) {
			int[] next = q.poll();
			
			// ���� ����Ⱑ ������
			if(map[next[0]][next[1]] < lv && map[next[0]][next[1]] != 0) {
				eat++;
				map[next[0]][next[1]] = 0;
				
				if(eat == lv) {
					lv++;
					eat = 0;
				}
				
				// �Ʊ��� ��ġ ����
				start = new int[] {next[0], next[1], 0};
				
				// �̵��Ÿ� ��ȯ
				return next[2];
			}
			
			// ���Ž��
			for(int i = 0; i < delta.length; i++) {
				int nr = next[0] + delta[i][0];
				int nc = next[1] + delta[i][1];
				
				// ��ǥ ��ȿ�� �˻�
				if(nr < 0 || nc < 0 || nr >= size || nc >= size)
					continue;
				
				// �ڽź��� ū ����Ⱑ �ִ� ĭ�� ��� X
				if(map[nr][nc] > lv)
					continue;
				
				// �湮���� üũ
				if(visited[nr][nc] == true)
					continue;
				
				q.add(new int[] {nr, nc, next[2]+1});
				visited[nr][nc] = true;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		init();		
		int count = 0;
		
		while(true) {
			visited = new boolean[size][size];
			int dist = BFS(start);
			
			// ���� ����Ⱑ ���� ������ �ݺ�
			if(dist == -1) break;
			
			count += dist;
		}
		
		System.out.println(count);
	}
}
