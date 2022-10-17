import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Queue<Integer> docs = new ArrayDeque<>();
            int[] priorities = new int[10]; 
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                docs.offer(priority);
                priorities[priority]++;
            }
            
            int order = 0;
            while (!docs.isEmpty()) {
                int doc = docs.poll();
                if (!isAvailable(priorities, doc)) docs.offer(doc);
                else {
                    order++;
                    priorities[doc]--;
                    if (M == 0) break;
                }
                M--;
                if (M < 0) M = docs.size() - 1;
            }
            
            sb.append(order).append("\n");
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }
    
    static boolean isAvailable(int[] priorities, int priority) {
        for (int i = priority + 1, size = priorities.length; i < size; i++) {
            if (priorities[i] > 0) return false;
        }
        return true;
    }
}