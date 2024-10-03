package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Seat {
	public int row, col; // �¼� ��ǥ
	public int friend; // ������ ĭ�� �����ϴ� �л� ��
	public int empty; // ������ ĭ�� ����ִ� �¼� ��
	public Seat(int row, int col, int friend, int empty) {
		this.row = row; this.col = col; this.friend = friend; this.empty = empty;
	}
}

public class BJ21608 {
	private static int size;
	private static int student; // �л� ��
	private static int[][] room; // ����
	private static int[][] friend; // �����ϴ� �л� list
	
	private static final int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		size = Integer.parseInt(st.nextToken());
		student = (int) Math.pow(size, 2);
		room = new int[size][size];
		friend = new int[student][5];
		
		for(int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				friend[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	private static int[] findSeat(int index) {
		// ���� �¼� ������ ���� PriorityQueue ���
		PriorityQueue<Seat> q = new PriorityQueue<>(new Comparator<Seat>() {
			public int compare(Seat o1, Seat o2) {
				// (1����) ������ ĭ�� �����ϴ� �л� ���� ���� ���� �¼�
				if(o1.friend != o2.friend) return o2.friend - o1.friend;
				
				// (2����) ������ ĭ�� ����ִ� �¼��� ���� ���� �¼�
				else if(o1.empty != o2.empty) return o2.empty - o1.empty;
				
				// (3����) ���� ��ȣ�� ���� ���� ĭ
				else if(o1.row != o2.row) return o1.row - o2.row;
				
				// (4����) ���� ��ȣ�� ���� ���� ĭ
				else return o1.col - o2.col;
			};
		});
		
		// �� �¼� Ž��
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				
				int f = 0; // ������ ĭ�� �����ϴ� �л� ��
				int e = 0; // ������ ĭ�� ����ִ� �¼� ��
				
				// �̹� ������ �¼��� ����
				if(room[r][c] != 0)
					continue;
				
				// ���Ž��
				for(int i = 0; i < delta.length; i++) {
					int nr = r + delta[i][0];
					int nc = c + delta[i][1];
					
					if(nr < 0 || nc < 0 || nr >= size || nc >= size)
						continue;
					
					// ���ƾƴ� �л��� �ִ��� Ȯ��
					for(int j = 1; j < friend[index].length; j++)
						if(friend[index][j] == room[nr][nc]) f++;
					
					// ����ִ� �¼��� �ִ��� Ȯ��
					if(room[nr][nc] == 0) e++;
				}
				
				// Ž���� �¼����� ���
				q.add(new Seat(r, c, f, e));
			}
		}
		
		// ���� �¼��� ��ǥ return;
		Seat s = q.poll();
		return new int[] {s.row, s.col};
	}
	
	private static int satisfaction() { // ������ ����
		int sum = 0;
		
		// �� �¼� Ž��
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				int studentNo = room[r][c]; // �л� ��ȣ
				int index = -1; // �����ϴ� �л��� ���� friend �迭�� index
				int f = 0; // ������ ĭ�� �����ϴ� �л� ��
				
				// �ش� �л��� friend �迭�� index ����
				for(int i = 0; i < friend.length; i++) {
					if(friend[i][0] == studentNo) {
						index = i;
						break;
					}
				}
				
				// ���Ž��
				for(int i = 0; i < delta.length; i++) {
					int nr = r + delta[i][0];
					int nc = c + delta[i][1];
					
					if(nr < 0 || nc < 0 || nr >= size || nc >= size)
						continue;
					
					// ���ƾƴ� �л��� �ִ��� Ȯ��
					for(int j = 1; j < friend[index].length; j++)
						if(friend[index][j] == room[nr][nc]) f++;
				}
				
				// ������ ����
				if(f == 1) sum += 1;
				else if(f == 2) sum += 10;
				else if(f == 3) sum += 100;
				else if(f == 4) sum += 1000;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		for(int i = 0; i < student; i++) {
			int studentNo = friend[i][0];

			// �ڸ� ����
			int[] seat = findSeat(i);
			
			// �ش� �ڸ��� �л� ���
			room[seat[0]][seat[1]] = studentNo;
		}
		
		System.out.println(satisfaction());
	}
}
