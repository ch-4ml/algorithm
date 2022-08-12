package boj.b2.p15829;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main_15829_Hashing {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int len = Integer.parseInt(in.readLine());
		char[] characters = in.readLine().toCharArray();
		BigInteger sum = BigInteger.ZERO;
		BigInteger M = new BigInteger("1234567891");
		BigInteger num;
		BigInteger R;

		for(int i = 0; i < len; i++) {
			num = new BigInteger(String.valueOf(characters[i] - 96));
			R = new BigInteger("31");
			R = R.pow(i);
			num = num.multiply(R);
			sum = sum.add(num);
		}
		
		out.write(String.valueOf(sum.mod(M)));
		out.flush();
		out.close();
	}
}
