package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1260 {
	private static int v; // ������ ����
	private static int e; // ������ ����
	private static int s; // ���� ����
	private static ArrayList<Integer> graph[];
	
	private static boolean visited[];
	
	private static StringBuilder resultDFS = new StringBuilder();
	private static StringBuilder resultBFS = new StringBuilder();
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken()) + 1; // ������ ��ȣ�� 1������
		e = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[v];
		
		for(int i = 0; i < v; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		// ���� ��ȣ�� ���� ���� ���� �湮�ؾ� �ϹǷ� �������� ����
		for(int i = 0; i < v; i++) {
			Collections.sort(graph[i]);
		}
	}
	
	private static void dfs(int v) {	
		visited[v] = true;
		resultDFS.append(v + " ");
		
		for(int i = 0; i < graph[v].size(); i++) {
			if(visited[graph[v].get(i)] == false)
				dfs(graph[v].get(i));
		}
	}
	
	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		
		// ���� ����
		q.add(v);
		visited[v] = true;
		
		// BFS Ž��
		while(q.isEmpty() == false) {
			int next = q.poll();
			
			resultBFS.append(next + " ");

			for(int i = 0; i < graph[next].size(); i++) {
				int tmp = graph[next].get(i);
				
				if(visited[tmp] == false) {
					q.add(tmp);
					visited[tmp] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		// DFS ����
		visited = new boolean[v];
		dfs(s);
		
		// BFS ����
		visited = new boolean[v];
		bfs(s);
		
		System.out.println(resultDFS.toString());
		System.out.println(resultBFS.toString());
	}
}
