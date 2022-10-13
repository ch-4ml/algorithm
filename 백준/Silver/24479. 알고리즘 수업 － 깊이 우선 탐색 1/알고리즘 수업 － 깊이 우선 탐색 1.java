import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] adjList;
    static int[] orders;
    static int order = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        orders = new int[N + 1];
        visited = new boolean[N + 1];
        
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            adjList[from].add(to);
            adjList[to].add(from);
        }
        
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        
        for (int i = 1; i <= N; i++) { 
            adjList[i].sort(comparator);
        }

        orders[R] = ++order;
        visited[R] = true;
        dfs(R);
        for (int i = 1; i <= N; i++) sb.append(orders[i]).append("\n");
        out.write(sb.toString());
        out.flush();
        out.close();
    }
    
    
    static void dfs(int v) {
        for (int i = 0, size = adjList[v].size(); i < size; i++) {
            int current = adjList[v].get(i);
            if (visited[current]) continue;
            orders[current] = ++order;
            visited[current] = true;
            dfs(current);
        }
    }
}