package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder res = new StringBuilder();
		
		while(true) {
			String tc = br.readLine(); // �׽�Ʈ ���̽�
			
			// ��������
			if(tc.equals("end")) break;
			
			boolean isAcceptable = false; // �ܾ� �� ���			
			int countConsonant = 0;	// ���� ���� ī��Ʈ
			int countVowel = 0;		// ���� ���� ī��Ʈ
			
			Character prev = '\0';	// ���� ����
			Character curr;			// ���� ����
			
			for(int i = 0; i < tc.length(); i++) {
				curr = tc.charAt(i);
				
				// (����1) ����(a,e,i,o,u) �ϳ��� �ݵ�� �����Ͽ��� �Ѵ�.
				if(curr == 'a' || curr == 'e' || curr == 'i' || curr == 'o' || curr == 'u') {
					isAcceptable = true;
				}
				
				// (����2) ������ 3�� Ȥ�� ������ 3�� �������� ���� �� �ȴ�.
				if(curr == 'a' || curr == 'e' || curr == 'i' || curr == 'o' || curr == 'u') {
					countConsonant++;
					countVowel = 0;
				} else {
					countVowel++;
					countConsonant = 0;
				}
				
				if(countConsonant >= 3 || countVowel >= 3) {
					isAcceptable = false;
					break;
				}
				
				// (����3) ���� ���ڰ� ���������� �ι� ���� �ȵǳ�, ee �� oo�� ����Ѵ�.
				if(curr != 'e' && curr != 'o' && curr == prev) {
					isAcceptable = false;
					break;
				}
				
				prev = curr;
			}
			
			if(isAcceptable) res.append("<" + tc + "> is acceptable.\n");
			else res.append("<" + tc + "> is not acceptable.\n");
		}
		
		System.out.println(res.toString());
	}
}
