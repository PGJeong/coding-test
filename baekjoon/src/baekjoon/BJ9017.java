package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Team {
	public int no, score, fifth, count; // �� ��ȣ, ����, 5��° ������ ����, ���� ��
	public Team(int no, int score) { this.no = no; this.score = score; count = 1; }
}

public class BJ9017 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽� ��
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine()); // ������ ��
			Team[] team = new Team[n + 1];
			int[] data = new int[n];
			int[] player = new int[n + 1]; // �� ���� ������ ��
			
			PriorityQueue<Team> q = new PriorityQueue<>(new Comparator<Team>() {
				@Override
				public int compare(Team t1, Team t2) {
					if(t1.score != t2.score) return t1.score - t2.score; // (1����) ���� ������ ���� ��
					else return t1.fifth - t2.fifth; // (2����) �ټ� ��° ������ ������ ���� ��
				}
			});
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int teamNo = Integer.parseInt(st.nextToken());
				player[teamNo]++;
				data[j] = teamNo;
			}
			
			int cnt = 1; // ����
			
			for(int j = 0; j < n; j++) {
				int teamNo = data[j];
				
				// ���� ���� 6�� ������ ���� �������� ����
				if(player[teamNo] < 6) continue;
				
				if(team[teamNo] == null) {
					team[teamNo] = new Team(teamNo, cnt);
				} else {
					team[teamNo].count++;
					
					if(team[teamNo].count < 5) team[teamNo].score += cnt;
					else if(team[teamNo].count == 5) team[teamNo].fifth = cnt;
					else if(team[teamNo].count == 6) q.add(team[teamNo]);
				}
				
				cnt++;
			}
			
			System.out.println(q.poll().no);
		}
		
	}
}
