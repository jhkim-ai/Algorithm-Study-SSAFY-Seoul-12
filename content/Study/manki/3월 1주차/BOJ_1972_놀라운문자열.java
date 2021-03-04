// https://www.acmicpc.net/problem/1972
// 놀라운문자열
// 구현
package boj;

import java.io.*;
 
public class BOJ_1972 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
        	String s = br.readLine();
        	if(s.equals("*")) break;
        	sb.append(s).append(" is ");
        	if(!check(s)) sb.append("NOT ");
        	sb.append("surprising").append('\n');
        }
        
        System.out.println(sb);
    }
    
    public static boolean check(String s) {
    	for(int i = 1; i<s.length(); ++i) {
    		boolean[][] alphabet = new boolean[26][26];
    		for(int j = 0; j+i<s.length(); ++j) {
    			if(alphabet[s.charAt(j)-'A'][s.charAt(j+i)-'A']) return false;
    			alphabet[s.charAt(j)-'A'][s.charAt(j+i)-'A'] = true;
    		}
    	}
    	return true;
    }
    
}