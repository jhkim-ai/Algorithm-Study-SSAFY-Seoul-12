// 1541, 잃어버린 괄호 | https://www.acmicpc.net/problem/1541
// 11,500KB | 76ms
package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1541 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		String digit = "";
		// 첫 번째 숫자 res로 두고
		int idx = 0;
		while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
			digit += s.substring(idx, ++idx);
		}
		int res = Integer.parseInt(digit);

		// 괄호를 적절히 쳐서 --> -가 나오면? 뒤에 나오는 숫자 다 빼면 된다.
		if (idx == s.length()) {
			System.out.println(res);
			return;
		}
		digit = "";	// 숫자면 digit에 계속 추가
		boolean flag = false; // false: +, true: -
		for (int i = idx; i < s.length(); i++) {
			// 숫자면
			if (Character.isDigit(s.charAt(i))) {
				digit += s.substring(i, i + 1);
			} 
			// 숫자 아니면 (+ or -)
			else {
				// '-'연산자가 앞에 있고, digit이 빈 문자열이 아니면 - 연산
				// !digit.equals("") 없으면 
				// 55-50+40의 경우 55: res에 저장되어 있고, digit: "" 상태에서 연산 시도해서 에러
				if (flag && !digit.equals("")) {
					res -= Integer.parseInt(digit);
				}
				if (!flag && !digit.equals("")) {
					res += Integer.parseInt(digit);
				}
				// 연산 후 digit 빈 문자열로 초기화
				digit = "";
				// 연산자가 - 나오면 flag를 true로 바꾼다. 이후 나오는 숫자는 모두 빼면 된다.
				if (s.substring(i, i + 1).equals("-")) {
					flag = true;
				}
			}
		}
		// 마지막에 나온 숫자까지 뺀다.
		if (flag) res -= Integer.parseInt(digit);
		else res += Integer.parseInt(digit);

		System.out.println(res);
	}

}
