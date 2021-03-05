package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String calc = br.readLine();
		int cnt = 0;
		List<Integer> num = new ArrayList<>();
		int size = calc.length();
		for (int i=0;i<size;i++) {
			char temp = calc.charAt(i);
			if (Character.isDigit(temp)) cnt++; // 숫자라면 cnt++
			else { // 연산자가 나오면
				num.add(Integer.parseInt(calc.substring(i-cnt, i))); // 현재 위치-cnt부터 현재 위치까지 숫자
				cnt = 0;
				if (temp=='-') cnt++; // 연산자지만 마이너스 값을 표현하기 위해 넣어줘야함
			}
		}
		if (cnt>0) num.add(Integer.parseInt(calc.substring(size-cnt, size)));
		
		int ans = num.get(0);
		boolean flag = false;
		for (int i=1;i<num.size();i++) {
			if (num.get(i)<0) { // 음수면
				flag = true; 
				ans+=num.get(i); // 음수 더해줌 = 빼줌 
			}
			else if (flag) ans-=num.get(i); // 음수가 아니지만 음수가 한번이라도 나왔으면 빼줌
			else ans+=num.get(i); // 음수가 한번도 나오지 않았다면 더해줌
		}
		System.out.println(ans);
	}
}
