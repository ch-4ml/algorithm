import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        hanoi(N, 1, 2, 3);
        
        out.write(cnt + "\n");
        out.write(sb.toString());
        out.flush();
        out.close();
    }
    
    static void hanoi(int n, int from, int temp, int to) {
        if (n == 0) return;
        hanoi(n - 1, from, to, temp);
        sb.append(from).append(" ").append(to).append("\n");
        cnt++;
        hanoi(n - 1, temp, from, to);
    }
}