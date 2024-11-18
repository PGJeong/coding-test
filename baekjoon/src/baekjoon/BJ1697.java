package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1697 {
	public static void main(String[] args) {
		// init
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt(); // ������
		int e = sc.nextInt(); // ������
		sc.close();
		
		// BFS Ž��
		Queue<int[]> q = new LinkedList<>(); // q[0]: ������ġ, q[1]: ����ð�
		boolean[] visited = new boolean[100001]; // (��������) �������� ���������� �տ� �������� �ְ�, ������/���������� �ڷ� �� ���� �־�� ��
		
		q.add(new int[] {s, 0});
		visited[s] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			// �������� ������ ���
			if(curr[0] == e) {
				System.out.println(curr[1]);
				break;
			}
			
			// (1) x-1 ��ġ�� �̵�
			if(curr[0]-1 >= 0 && visited[curr[0]-1] == false) {
				q.add(new int[] {curr[0]-1, curr[1]+1});
				visited[curr[0]-1] = true;
			}
			
			// (2) x+1 ��ġ�� �̵�
			if(curr[0]+1 < visited.length && visited[curr[0]+1] == false) {
				q.add(new int[] {curr[0]+1, curr[1]+1});
				visited[curr[0]+1] = true;
			}
			
			// (3) 2x ��ġ�� �̵�
			if(curr[0]*2 < visited.length && visited[curr[0]*2] == false) {
				q.add(new int[] {curr[0]*2, curr[1]+1});
				visited[curr[0]*2] = true;
			}
		}
	}
}
