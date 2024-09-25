package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ2251 {
	private static int capacity[]; // �ִ�뷮
	private static boolean visited[][][]; // �˻��� ���
	private static ArrayList<Integer> answer;
	
	private static void init() {
		Scanner sc = new Scanner(System.in);
		
		capacity = new int[3];
		visited = new boolean[201][201][201];
		answer = new ArrayList<Integer>();
		
		for(int i = 0; i < 3; i++)
			capacity[i] = sc.nextInt();
	}
	
	private static void dfs(int now[]) {
		if(visited[now[0]][now[1]][now[2]] == true) {
			return;
		}
		
		if(now[0] == 0) {
			if(answer.indexOf(now[2]) == -1)
				answer.add(now[2]);
		}
		
		visited[now[0]][now[1]][now[2]] = true;
		
		// now[i] -> now[j]�� �ο�
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i != j) {
					int n[] = now.clone();
					
					if(capacity[j] - now[j] >= now[i]) {
						// (1.) now[i]�� ��� �״� ���
						
						n[j] += n[i];
						n[i] = 0;
						dfs(n);
						
					} else {
						// (2.) now[j]�� ���� ä��� ���
						
						n[i] -= capacity[j] - now[j];
						n[j] = capacity[j];
						dfs(n);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		init();
		
		dfs(new int[] {0, 0, capacity[2]});
		
		Collections.sort(answer);		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < answer.size(); i++)
			sb.append(answer.get(i) + " ");
		
		System.out.println(sb.toString());
	}
}
