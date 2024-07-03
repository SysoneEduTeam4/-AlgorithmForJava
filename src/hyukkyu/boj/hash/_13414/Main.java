package hyukkyu.boj.hash._13414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		String[] array = new String[L];
		
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		for(int i = 1; i <= L; i++) {
			String str = br.readLine();
			
			if(linkedHashSet.contains(str)) {
				linkedHashSet.remove(str);
				
			}
			linkedHashSet.add(str);
		}
		
		int count = 0;
		for (String s : linkedHashSet) {
			if (count == K) {
				break;
			}
			System.out.println(s);
			count++;
			
		}
	}
}
