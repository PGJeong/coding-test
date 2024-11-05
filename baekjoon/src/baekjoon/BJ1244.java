package baekjoon;

import java.util.Scanner;

public class BJ1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size;	// ����ġ ����
		int[] state;// ����ġ
		int stud;	// �л� ��
		
		size = sc.nextInt();
		state = new int[size];
		for(int i = 0; i < size; i++)
			state[i] = sc.nextInt();
		stud = sc.nextInt();
		
		for(int i = 0; i < stud; i++) {
			int sex = sc.nextInt(); // �л� ����
			int num = sc.nextInt(); // �л��� ���� �� (0-based ��ȯ �ʿ�)
			int tmp;
			
			switch(sex) {
			case 1: // ���л�
				tmp = 1;
				while(true) {
					if(num*tmp > size) break;
					state[num*tmp-1] = (state[num*tmp-1] == 0 ? 1 : 0);
					tmp++;
				}
				break;
				
			case 2: // ���л�
				tmp = 1;
				while(true) {
					if(num-tmp < 1 || num+tmp > size || state[num-tmp-1] != state[num+tmp-1]) break;
					state[num-tmp-1] = (state[num-tmp-1] == 0 ? 1 : 0);
					state[num+tmp-1] = (state[num+tmp-1] == 0 ? 1 : 0);
					tmp++;
				}
				state[num-1] = (state[num-1] == 0 ? 1 : 0);
				break;
			}
		}
		
		for(int i = 0; i < size; i++) {
			if(i != 0 && i % 20 == 0) System.out.println(); // 20������ ����
			System.out.print(state[i] + " ");
		}
		
		sc.close();
	}
}
