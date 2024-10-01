package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point2 {
	public int r, c;
	public Point2(int r, int c) { this.r = r; this.c = c; }
	@Override
	public boolean equals(Object obj) {
		if(this.r == ((Point2)obj).r && this.c == ((Point2)obj).c)
			return true;
		else
			return false;
	}
}

class Move {
	public int sec;
	public String dir;
	public Move(int sec, String dir) { this.sec = sec; this.dir = dir; }
}

public class BJ3190 {
	private static int size;
	private static int k; // ����� ����
	private static int l; // ������ȯ Ƚ��
	private static int[][] map;  // 0: �� ĭ, 1: ���
	private static Queue<Move> moves; // ������ȯ ���
	
	private static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // ����(��)���� �ð����
	private static int currentDir; // ���� ������� (��90 ȸ�� �� +1, ��90 ȸ�� �� -1)
	
	private static ArrayList<Point2> snake; // ��
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		size = Integer.parseInt(br.readLine());
		map = new int[size][size];
		k = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			// (�������� 1.) �Է°��� 1-based index�� �־����Ƿ� 0-based index�� ��ȯ (index - 1)
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		
		l =Integer.parseInt(br.readLine());
		moves = new LinkedList<>();
		
		for(int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			moves.add(new Move(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		snake = new ArrayList<>();
		
		snake.add(0, new Point2(0, 0)); // �ʱ� ���� ���̴� 1, ���� ��ġ�� 0,0
		currentDir = 1; // �ʱ� ��������� ������
	}
	
	private static int game() {
		int sec = 0; // �ð�(��)
		
		Move next = moves.poll();
		
		while(true) {
			// �� �� �̵� �� 1��++
			sec++;
						
			// ������ȯ ��� Ȯ��
			if(next != null && sec == next.sec + 1) { // (�������� 2.) "X�ʰ� ���� �ڿ� ȸ��"�̶�� ��
				switch(next.dir) {
				case "L": // �������� 90ȸ��
					currentDir = (currentDir + 3) % 4;
					break;
				case "D": // ���������� 90ȸ��
					currentDir = (currentDir + 1) % 4;
					break;
				}
				next = moves.poll();
			}
			
			// �̵��� ��ǥ
			int nr = snake.get(0).r + delta[currentDir][0];
			int nc = snake.get(0).c + delta[currentDir][1];
			
			// (�������� 1.) ���� �ε����� ��������
			if(nr < 0 || nc < 0 || nr >= size || nc >= size)
				break;
			
			// (�������� 2.) �ڱ� �ڽ��� ���� �ε����� ��������
			if(snake.contains(new Point2(nr, nc))) // contains()�� ���������� ��ü�� equals()�� ����Ͽ� ��ҿ� ��
				break;
			
			// �����̸� �÷� �Ӹ��� ����ĭ�� ��ġ
			snake.add(0, new Point2(nr, nc));
			
			// �̵��� ĭ�� ����� ������, ����� �������� ������ ��������
			if(map[nr][nc] == 1) {
				map[nr][nc] = 0;
			}
			// �̵��� ĭ�� ����� ������, �����̸� �ٷ� ���� ����
			else {
				snake.remove(snake.size()-1);
			}
		}
		
		return sec;
	}
	
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(game());
	}
}
