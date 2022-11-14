import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(in.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    
    int min = Integer.MAX_VALUE;
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    st = new StringTokenizer(in.readLine());
    for (int i = 0; i < N; i++) {
        if (queue.size() == K) queue.removeFirst();
        if ("1".equals(st.nextToken())) queue.offer(i);
        if (queue.size() == K) min = Math.min(min, queue.peekLast() - queue.peekFirst() + 1);
    }
    
    if (min == Integer.MAX_VALUE) min = -1;
    out.write(min + "");
    out.flush();
    out.close();
  }
}