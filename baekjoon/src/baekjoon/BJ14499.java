package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dice {
	private static Dice instance = new Dice(); // Singleton Pattern
	public static final int TOP = 0, BOTTOM = 1, LEFT = 2, RIGHT = 3, FRONT = 4, BACK = 5;
	public int[] data = new int[6];
	
	public void roll(int dir) {
		// ��(1)
		if(dir == 1) swap(LEFT, TOP, RIGHT, BOTTOM);
		// ��(2)
		else if(dir == 2) swap(RIGHT, TOP, LEFT, BOTTOM);
		// ��(3)
		else if(dir == 3) swap(FRONT, TOP, BACK, BOTTOM);
		// ��(4)
		else if(dir == 4) swap(BACK, TOP, FRONT, BOTTOM);
	}
	
	private void swap(int i0, int i1, int i2, int i3) {
		int temp = data[i3];
		data[i3] = data[i2];
		data[i2] = data[i1];
		data[i1] = data[i0];
		data[i0] = temp;
	}
	
	private Dice() {}
	public static Dice getInstance() { return instance; }
}

public class BJ14499 {
	private static int row; // ������ ����ũ��
	private static int col; // ������ ����ũ��
	private static int[][] map;
	
	private static int[] loc; // �ֻ��� ��ġ
	private static int numOrder; // ����� ����
	private static int[] order; // ���
	
	private static final int[][] delta = {{0, 1}, {0, -1}, {-1, 0} ,{1, 0}}; // ��,��,��,��
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		loc = new int[2];
		loc[0] = Integer.parseInt(st.nextToken());
		loc[1] = Integer.parseInt(st.nextToken());
		numOrder = Integer.parseInt(st.nextToken());
		order = new int[numOrder];
		
		for(int r = 0; r < row; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < col; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < numOrder; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static int move(int dir) {
		// map���� �̵��� ��ǥ ���
		int nr = loc[0] + delta[dir - 1][0];
		int nc = loc[1] + delta[dir - 1][1];
		
		// ��ǥ ��ȿ�� �˻� (��ȿ���� ������ -1 return)
		if(nr < 0 || nc < 0 || nr >= row || nc >= col)
			return -1;
		
		// �ֻ��� ��ġ �̵�
		loc[0] = nr; loc[1] = nc;
		
		// �ֻ��� �ش� �������� ������
		Dice dice = Dice.getInstance();
		dice.roll(dir);
		
		// �̵��� ĭ�� �����ִ� ���� 0�̸�, �ֻ����� �ٴڸ鿡 �����ִ� ���� ĭ�� ����
		if(map[nr][nc] == 0) {
			map[nr][nc] = dice.data[Dice.BOTTOM];
		}
		// �̵��� ĭ�� �����ִ� ���� 0�� �ƴϸ�, ĭ�� �����ִ� ���� �ֻ����� �ٴڸ鿡 ����Ǹ�, ĭ�� �����ִ� ���� 0�� ��
		else {
			dice.data[Dice.BOTTOM] = map[nr][nc];
			map[nr][nc] = 0;
		}
		
		return dice.data[Dice.TOP];
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		for(int i = 0; i < numOrder; i++) {
			int res = move(order[i]);
			if(res != -1) System.out.println(res);
		}
	}
}
