package boj.s5.p10814;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class User implements Comparable<User> {
	int age;
	String name;
	int idx;
	
	public User(int age, String name, int idx) {
		super();
		this.age = age;
		this.name = name;
		this.idx = idx;
	}

	@Override
	public int compareTo(User o) {
		return this.age == o.age ? this.idx - o.idx : this.age - o.age;
	}
}

public class Main_10814_나이순정렬 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int idx = 0;
		User[] users = new User[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			users[i] = new User(Integer.parseInt(st.nextToken()), st.nextToken(), idx++); 
		}
		
		Arrays.sort(users);
		
		for(int i = 0; i < N; i++) {
			sb.append(users[i].age).append(" ").append(users[i].name).append("\n");
		}
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
