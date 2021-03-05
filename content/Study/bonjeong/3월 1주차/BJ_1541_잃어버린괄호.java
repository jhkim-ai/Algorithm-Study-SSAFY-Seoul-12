package Study7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		// 목표: 더하기 먼저 수행 -> 그 다음 뺄셈
		
		// - 로 먼저 나누기. 
		String[] arr2 = s.split("-");
//		System.out.println(Arrays.toString(arr2));
		
		// + 연산 있으면 +로 나눠주고 그 숫자들 다 더해주기
		for(int i= 0; i < arr2.length; i++) {
			if(arr2[i].contains("+")) {
//				System.out.println(arr2[i]);
				String[] temp = arr2[i].split("\\+"); //이스케이프처리 
//				System.out.println(Arrays.toString(temp));
				int sum = 0;
				for(int j = 0; j < temp.length; j++) {
					sum += Integer.parseInt(temp[j]);
				}
				arr2[i] = Integer.toString(sum);
			}
//			System.out.println(Arrays.toString(arr2));
		}
		
		// + 연산 모두 수행 수 - 연산 수행하기
		int answ = Integer.parseInt(arr2[0]);
		for(int i = 1; i < arr2.length; i++) {
			answ = answ - Integer.parseInt(arr2[i]);
		}
		
		System.out.println(answ);
	}
}
