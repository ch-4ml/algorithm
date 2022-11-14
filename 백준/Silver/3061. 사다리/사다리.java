import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static List<Integer> ladder;
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(in.readLine());
            ladder = new ArrayList<>();
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                ladder.add(Integer.parseInt(st.nextToken()) - 1);
            }
            
            int count = 0;
            // index 구하기 -> 원래 index와 차이 구하기 -> 땡기기
            for (int i = 0; i < N; i++) {
                int idx = ladder.indexOf(i); // i번 자리에 와야하는 숫자의 index 구하기
                ladder.remove(idx); // 그 자리에서 삭제하고
                ladder.add(i, i); // i번 자리에 추가
                count += Math.abs(idx - i); // 이동 거리 구하기
            }
            
            sb.append(count).append("\n");
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }  
}