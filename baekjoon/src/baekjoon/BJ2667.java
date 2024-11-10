package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ2667 {
	private static int size;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // ���Ž��
	
	private static void init() {
		Scanner sc = new Scanner(System.in);
		size = Integer.parseInt(sc.nextLine());
		map = new int[size][size];
		visited = new boolean[size][size];
		
		for(int r = 0; r < size; r++) {
			String str = sc.nextLine();
			for(int c = 0; c < size; c++) 
				map[r][c] = (str.charAt(c) == '0' ? 0 : 1);
		}
		sc.close();
	}
	
	private static int DFS(int r, int c) {
		int count = 1; // ������ ���� ��
		visited[r][c] = true;
		
		// ���Ž��
		for(int i = 0; i < delta.length; i++) {
			int nr = r + delta[i][0];
			int nc = c + delta[i][1];
			
			// ��ǥ�� ��ȿ���� ���� ���
			if(nr < 0 || nc < 0 || nr >= size || nc >= size) continue;
			
			// �̹� �湮�� ��ǥ�� ��� || �� ĭ�� ���
			if(visited[nr][nc] || map[nr][nc] == 0) continue;
			
			count += DFS(nr, nc);
			visited[nr][nc] = true;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		init();
		
		int count = 0; // �� ���� ��
		ArrayList<Integer> arr = new ArrayList<>(); // �� ������ ���� ��
		
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				if(map[r][c] == 1 && visited[r][c] == false) {
					count++;
					arr.add(DFS(r, c));
				}
			}
		}
		
		// arr �������� ����
		Collections.sort(arr); // �迭 ���� �� Arrays.sort(), �÷��� ���� �� Collections.sort() ���
		
		System.out.println(count);
		for(int i : arr)
			System.out.println(i);
	}
}