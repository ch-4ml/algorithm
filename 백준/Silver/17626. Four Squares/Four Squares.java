import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine()); // N <= 50000, 시간 제한이 0.5초라 빨리 계산될 수 있는 범위로 케이스를 제공하는 듯?
        int[] dt = new int[N + 1]; // 자연수 N을 제곱수들의 합으로 나타냈을 때, 구성되는 제곱수의 최소 개수
        
        for (int i = 1; i <= N; i++) {
            dt[i] = dt[i - 1] + 1;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                dt[i] = Math.min(1 + dt[i - j * j], dt[i]);
            }
        }
        
        out.write(dt[N] + "");
        out.flush();
        out.close();
    }
}