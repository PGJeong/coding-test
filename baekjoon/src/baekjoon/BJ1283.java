package baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ1283 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder res = new StringBuilder();
		HashSet<Character> set = new HashSet<>();
		int n = Integer.parseInt(sc.nextLine()); // �ܾ� ����
		
		for(int i = 0; i < n; i++) {
			String word = sc.nextLine();
			int count = 0; // �ܾ��� �� ��° ���ڸ� ����Ű�� �����ߴ���
			boolean complete = false; // ���밡���� ����Ű�� ã�Ҵ���
			
			// (1����) �ܾ��� ù ����
			StringTokenizer st = new StringTokenizer(word);
			
			while(st.hasMoreTokens()) {
				String s = st.nextToken();
				
				if(!set.contains(Character.toUpperCase(s.charAt(0)))) {
					set.add(Character.toUpperCase(s.charAt(0)));
					complete = true;
					break;
				} else {
					count += s.length() + 1;
				}
			}
			
			// (2����) ���ʺ��� �ܾ �����ϴ� ���ĺ�
			if(!complete) {
				for(int j = 0; j < word.length(); j++) {
					if(!set.contains(Character.toUpperCase(word.charAt(j))) && word.charAt(j) != ' ') {
						set.add(Character.toUpperCase(word.charAt(j)));
						count = j;
						complete = true;
						break;
					}
				}
			}
			
			// ��°�
			if(complete) {
				for(int j = 0; j < word.length(); j++) {
					if(j == count) res.append("[" + word.charAt(j) + "]");
					else res.append(word.charAt(j));
				}
				res.append("\n");
			} else {
				res.append(word + "\n");
			}
		}
		
		System.out.print(res.toString());
		sc.close();
	}
}
