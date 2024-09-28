package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	public int x, y, count;
	public Point(int x, int y, int count) { this.x = x; this.y = y; this.count = count; }
}

public class BJ2178 {
	private static int row;
	private static int col;
	private static int[][] map;
	private static boolean[][] visited;
	private static final int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		visited = new boolean[row][col];
		
		for(int i = 0; i < row; i++) {
			String s = br.readLine();
			for(int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(Character.toString(s.charAt(j)));
			}
		}
	}
	
	private static int BFS() {
		Queue<Point> q = new LinkedList<>();
		
		// 시작정점 추가
		q.add(new Point(0, 0, 1));
		visited[0][0] = true;
		
		// BFS 탐색
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i = 0; i < delta.length; i++) {
				int nx = p.x + delta[i][0];
				int ny = p.y + delta[i][1];
				
				// 좌표가 유효하지 않으면
				if(nx < 0 || ny < 0 || nx >= row || ny >= col)
					continue;
				
				// 해당 칸이 막혀있으면
				if(map[nx][ny] == 0)
					continue;
				
				// 이미 방문했으면
				if(visited[nx][ny] == true)
					continue;
				
				// 도착했으면
				if(nx == row-1 && ny == col-1)
					return p.count+1;
				
				q.add(new Point(nx, ny, p.count+1));
				visited[nx][ny] = true;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(BFS());
	}
}
