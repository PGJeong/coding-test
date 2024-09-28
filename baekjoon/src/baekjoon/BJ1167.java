package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Edge {
	public int vertex, dist;
	public Edge(int vertex, int dist) { this.vertex = vertex; this.dist = dist; }
}

public class BJ1167 {
	// Memo: Ʈ���� ������ķ� ���� �� �޸� �ʰ� -> ��������Ʈ�� ����
	private static int v;
	private static ArrayList<Edge>[] tree;
	private static boolean[] visited;
	
	private static void init() {
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt() + 1; // ���� ��ȣ�� 1���� ����
		tree = new ArrayList[v];
		
		for(int i = 1; i < v; i++)
			tree[i] = new ArrayList<Edge>();
		
		for(int i = 1; i < v; i++) {
			int a = sc.nextInt();
			while(true) {
				int b = sc.nextInt();
				
				if(b == -1) break;
				
				int dist = sc.nextInt();
				tree[a].add(new Edge(b, dist));
			}
		}
		
		sc.close();
	}
	
	private static Edge BFS(int start) {
		// start ������ �������� ���� �Ÿ��� �� "����"�� "�Ÿ�"�� return
		int max = 0;
		int vertex = start;
		
		Queue<Edge> q = new LinkedList<>();
		
		// �������� ����
		q.add(new Edge(start, 0));
		visited[start] = true;
		
		// BFS Ž��
		while(!q.isEmpty()) {
			Edge next = q.poll();
			
			// start �������� �ִ� �Ÿ� ����
			int tmp = Math.max(max, next.dist);
			if(max != tmp) { // �ִ밪 ������ �ʿ��� ���
				max = tmp;
				vertex = next.vertex;
			}
			
			for(Edge e : tree[next.vertex]) {
				if(visited[e.vertex] == false) {
					// start �������� e ���������� �Ÿ� �ջ�
					q.add(new Edge(e.vertex, e.dist + next.dist));
					visited[e.vertex] = true;
				}
			}
		}
		
		return new Edge(vertex, max);
	}
	
	public static void main(String[] args) {
		init();
		
		// (1.) ������ ��忡�� ���� �� ��η� ����� ���� Ʈ���� ������ �ش��ϴ� �� ��� �� �ϳ�
		visited = new boolean[v];
		Edge a = BFS(1);	
		// (2.) a�� �������� ���� �Ÿ��� �� ���������� �Ÿ��� Ʈ���� ����
		visited = new boolean[v];
		Edge b = BFS(a.vertex);
		
		System.out.println(b.dist);
	}
}
