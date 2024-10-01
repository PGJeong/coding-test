package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13460 {
	private static int N, M; // ������ ����, ����
	private static char[][] board;
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		
		for(int r = 0; r < N; r++) {
			String str = br.readLine();
			for(int c = 0; c < M; c++)
				board[r][c] = str.charAt(c);
		}
	}
	
	private static char[][] move(int dir, char[][] board) {
		// (��������) 2���� �迭�� ��� clone()�� ����ϸ�, ���� 1���� �迭���� ������ ����� (��������)
		char[][] newboard = new char[N][M];
		
		boolean flag_S = false; // ���Ӽ��� flag
		boolean flag_F = false; // ���ӽ��� flag
		
		int[] locR = null; // �������� ��ǥ
		int[] locB = null; // �Ķ����� ��ǥ
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				// 2���� �迭 ����
				newboard[r][c] = board[r][c];
				
				// �� ���� ��ǥ ����
				if(newboard[r][c] == 'R') { 
					locR = new int[] {r, c};
					newboard[r][c] = '.'; // ��ġ ���� �� ��ĭ���� ����
				}
				if(newboard[r][c] == 'B') { 
					locB = new int[] {r, c};
					newboard[r][c] = '.'; // ��ġ ���� �� ��ĭ���� ����
				}
			}
		}
		
		char char1, char2;
		int[] loc1, loc2;
		
		// �̵�
		// ��
		if(dir == 0) {
			// ��ǥ �� ���� �ִ� �������� �̵� (���� ���� �ִ� ��� ���)
			if(locR[0] < locB[0]) {
				char1 = 'R';
				char2 = 'B';
				loc1 = locR;
				loc2 = locB;
			} else {
				char1 = 'B';
				char2 = 'R';
				loc1 = locB;
				loc2 = locR;
			}
			
			// 1��°�� �̵��� ���� (char1)
			while(true) {
				loc1[0]--; // ���� �� ĭ �̵�
				
				// �տ� ���� �ְų�, �տ� �ٸ� ������ ������ ���� �̵� �ߴ�
				if(newboard[loc1[0]][loc1[1]] == '#' || newboard[loc1[0]][loc1[1]] == char2) {
					loc1[0]++;
					newboard[loc1[0]][loc1[1]] = char1;
					break;
				}
				
				// ���� ���������� ������ ���� ���������� �������� (����)
				if(char1 == 'R' && newboard[loc1[0]][loc1[1]] == 'O') {
					flag_S = true;
					break;
				}
				
				// ���� �Ķ������� ������ ���� ���������� �������� (����)
				if(char1 == 'B' && newboard[loc1[0]][loc1[1]] == 'O') {
					flag_F = true;
					break;
				}
			}
			
			// 2��°�� �̵��� ���� (char2)
			while(true) {
				loc2[0]--; // ���� �� ĭ �̵�
				
				// �տ� ���� �ְų�, �տ� �ٸ� ������ ������ ���� �̵� �ߴ�
				if(newboard[loc2[0]][loc2[1]] == '#' || newboard[loc2[0]][loc2[1]] == char1) {
					loc2[0]++;
					newboard[loc2[0]][loc2[1]] = char2;
					break;
				}
				
				// ���� ���������� ������ ���� ���������� �������� (����)
				if(char2 == 'R' && newboard[loc2[0]][loc2[1]] == 'O') {
					flag_S = true;
					break;
				}
				
				// ���� �Ķ������� ������ ���� ���������� �������� (����)
				if(char2 == 'B' && newboard[loc2[0]][loc2[1]] == 'O') {
					flag_F = true;
					break;
				}
			}
		}
		
		// ��
		else if(dir == 1) {
			// ��ǥ �� �Ʒ��� �ִ� �������� �̵� (���� ���� �ִ� ��� ���)
			if(locR[0] > locB[0]) {
				char1 = 'R';
				char2 = 'B';
				loc1 = locR;
				loc2 = locB;
			} else {
				char1 = 'B';
				char2 = 'R';
				loc1 = locB;
				loc2 = locR;
			}
			
			// 1��°�� �̵��� ���� (char1)
			while(true) {
				loc1[0]++; // �Ʒ��� �� ĭ �̵�
				
				// �տ� ���� �ְų�, �տ� �ٸ� ������ ������ ���� �̵� �ߴ�
				if(newboard[loc1[0]][loc1[1]] == '#' || newboard[loc1[0]][loc1[1]] == char2) {
					loc1[0]--;
					newboard[loc1[0]][loc1[1]] = char1;
					break;
				}
				
				// ���� ���������� ������ ���� ���������� �������� (����)
				if(char1 == 'R' && newboard[loc1[0]][loc1[1]] == 'O') {
					flag_S = true;
					break;
				}
				
				// ���� �Ķ������� ������ ���� ���������� �������� (����)
				if(char1 == 'B' && newboard[loc1[0]][loc1[1]] == 'O') {
					flag_F = true;
					break;
				}
			}
			
			// 2��°�� �̵��� ���� (char2)
			while(true) {
				loc2[0]++; // �Ʒ��� �� ĭ �̵�
				
				// �տ� ���� �ְų�, �տ� �ٸ� ������ ������ ���� �̵� �ߴ�
				if(newboard[loc2[0]][loc2[1]] == '#' || newboard[loc2[0]][loc2[1]] == char1) {
					loc2[0]--;
					newboard[loc2[0]][loc2[1]] = char2;
					break;
				}
				
				// ���� ���������� ������ ���� ���������� �������� (����)
				if(char2 == 'R' && newboard[loc2[0]][loc2[1]] == 'O') {
					flag_S = true;
					break;
				}
				
				// ���� �Ķ������� ������ ���� ���������� �������� (����)
				if(char2 == 'B' && newboard[loc2[0]][loc2[1]] == 'O') {
					flag_F = true;
					break;
				}
			}
		}
		
		// ��
		else if(dir == 2) {
			// ��ǥ �� ���ʿ� �ִ� �������� �̵� (���� �࿡ �ִ� ��� ���)
			if(locR[1] < locB[1]) {
				char1 = 'R';
				char2 = 'B';
				loc1 = locR;
				loc2 = locB;
			} else {
				char1 = 'B';
				char2 = 'R';
				loc1 = locB;
				loc2 = locR;
			}
			
			// 1��°�� �̵��� ���� (char1)
			while(true) {
				loc1[1]--; // �������� �� ĭ �̵�
				
				// �տ� ���� �ְų�, �տ� �ٸ� ������ ������ ���� �̵� �ߴ�
				if(newboard[loc1[0]][loc1[1]] == '#' || newboard[loc1[0]][loc1[1]] == char2) {
					loc1[1]++;
					newboard[loc1[0]][loc1[1]] = char1;
					break;
				}
				
				// ���� ���������� ������ ���� ���������� �������� (����)
				if(char1 == 'R' && newboard[loc1[0]][loc1[1]] == 'O') {
					flag_S = true;
					break;
				}
				
				// ���� �Ķ������� ������ ���� ���������� �������� (����)
				if(char1 == 'B' && newboard[loc1[0]][loc1[1]] == 'O') {
					flag_F = true;
					break;
				}
			}
			
			// 2��°�� �̵��� ���� (char2)
			while(true) {
				loc2[1]--; // �������� �� ĭ �̵�
				
				// �տ� ���� �ְų�, �տ� �ٸ� ������ ������ ���� �̵� �ߴ�
				if(newboard[loc2[0]][loc2[1]] == '#' || newboard[loc2[0]][loc2[1]] == char1) {
					loc2[1]++;
					newboard[loc2[0]][loc2[1]] = char2;
					break;
				}
				
				// ���� ���������� ������ ���� ���������� �������� (����)
				if(char2 == 'R' && newboard[loc2[0]][loc2[1]] == 'O') {
					flag_S = true;
					break;
				}
				
				// ���� �Ķ������� ������ ���� ���������� �������� (����)
				if(char2 == 'B' && newboard[loc2[0]][loc2[1]] == 'O') {
					flag_F = true;
					break;
				}
			}
		}
		
		// ��
		else if(dir == 3) {
			// ��ǥ �� �����ʿ� �ִ� �������� �̵� (���� �࿡ �ִ� ��� ���)
			if(locR[1] > locB[1]) {
				char1 = 'R';
				char2 = 'B';
				loc1 = locR;
				loc2 = locB;
			} else {
				char1 = 'B';
				char2 = 'R';
				loc1 = locB;
				loc2 = locR;
			}
			
			// 1��°�� �̵��� ���� (char1)
			while(true) {
				loc1[1]++; // ���������� �� ĭ �̵�
				
				// �տ� ���� �ְų�, �տ� �ٸ� ������ ������ ���� �̵� �ߴ�
				if(newboard[loc1[0]][loc1[1]] == '#' || newboard[loc1[0]][loc1[1]] == char2) {
					loc1[1]--;
					newboard[loc1[0]][loc1[1]] = char1;
					break;
				}
				
				// ���� ���������� ������ ���� ���������� �������� (����)
				if(char1 == 'R' && newboard[loc1[0]][loc1[1]] == 'O') {
					flag_S = true;
					break;
				}
				
				// ���� �Ķ������� ������ ���� ���������� �������� (����)
				if(char1 == 'B' && newboard[loc1[0]][loc1[1]] == 'O') {
					flag_F = true;
					break;
				}
			}
			
			// 2��°�� �̵��� ���� (char2)
			while(true) {
				loc2[1]++; // ���������� �� ĭ �̵�
				
				// �տ� ���� �ְų�, �տ� �ٸ� ������ ������ ���� �̵� �ߴ�
				if(newboard[loc2[0]][loc2[1]] == '#' || newboard[loc2[0]][loc2[1]] == char1) {
					loc2[1]--;
					newboard[loc2[0]][loc2[1]] = char2;
					break;
				}
				
				// ���� ���������� ������ ���� ���������� �������� (����)
				if(char2 == 'R' && newboard[loc2[0]][loc2[1]] == 'O') {
					flag_S = true;
					break;
				}
				
				// ���� �Ķ������� ������ ���� ���������� �������� (����)
				if(char2 == 'B' && newboard[loc2[0]][loc2[1]] == 'O') {
					flag_F = true;
					break;
				}
			}
		}
		
		// return���� board[0][0]�� 'F'�̸� ���� ǥ��
		if (flag_F) return new char[][] {{'F'}};
		
		// return���� board[0][0]�� 'S'�̸� ���� ǥ�� (���������� ������������ �Ķ������� ���������� ����ó��)
		if (flag_S) return new char[][] {{'S'}};
		
		return newboard;
	}
	
	private static int BFS(char[][] board) {
		Queue<char[][]> q_board = new LinkedList<>(); // ���� ���� ����
		Queue<Integer> q_dir = new LinkedList<>(); // ���� ���� ����
		Queue<Integer> q_cnt = new LinkedList<>(); // ���� �̵� Ƚ��
		
		// �ʱ갪 ����
		q_board.add(board);
		q_dir.add(-1);
		q_cnt.add(0);
		
		// BFS Ž��
		while(!q_board.isEmpty()) {
			char[][] curr_board = q_board.poll();
			int curr_dir = q_dir.poll();
			int curr_cnt = q_cnt.poll();
			
			// �̵�Ƚ���� 10���� �ʰ��� ���
			if(curr_cnt > 10)
				break;
			
			// ��������(����)�� ���, �̵�Ƚ�� return
			if(curr_board[0][0] == 'S')
				return curr_cnt;
			
			// ��������(����)�� ���, �ǳʶٱ�
			if(curr_board[0][0] == 'F')
				continue;
			
			// �����¿� �̵�
			if(curr_dir != 0) { // ��
				q_board.add(move(0, curr_board));
				q_dir.add(0);
				q_cnt.add(curr_cnt + 1);
			}
			if(curr_dir != 1) { // ��
				q_board.add(move(1, curr_board));
				q_dir.add(1);
				q_cnt.add(curr_cnt + 1);
			}
			if(curr_dir != 2) { // ��
				q_board.add(move(2, curr_board));
				q_dir.add(2);
				q_cnt.add(curr_cnt + 1);
			}
			if(curr_dir != 3) { // ��
				q_board.add(move(3, curr_board));
				q_dir.add(3);
				q_cnt.add(curr_cnt + 1);
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(BFS(board));
	}
}
