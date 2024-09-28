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
	private static int v; // 정점의 개수
	private static int e; // 간선의 개수
	private static int s; // 시작 정점
	private static ArrayList<Integer> graph[];
	
	private static boolean visited[];
	
	private static StringBuilder resultDFS = new StringBuilder();
	private static StringBuilder resultBFS = new StringBuilder();
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken()) + 1; // 정점의 번호는 1번부터
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
		
		// 정점 번호가 작은 것을 먼저 방문해야 하므로 오름차순 정렬
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
		
		// 시작 정점
		q.add(v);
		visited[v] = true;
		
		// BFS 탐색
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
		
		// DFS 수행
		visited = new boolean[v];
		dfs(s);
		
		// BFS 수행
		visited = new boolean[v];
		bfs(s);
		
		System.out.println(resultDFS.toString());
		System.out.println(resultBFS.toString());
	}
}
