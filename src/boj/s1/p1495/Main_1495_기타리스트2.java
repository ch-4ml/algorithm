package boj.s1.p1495;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1495_기타리스트2 {
    
    static boolean[][] dt;
    static int[] volumes;
    static int N, S, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        volumes = new int[N + 1];
        st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        dt = new boolean[N + 1][M + 1]; // 현재 시점(N)에 만들어질 수 있는 모든 볼륨을 구하기
        dt[0][S] = true;
        
        for (int i = 1; i <= N; i++) {
            boolean flag = false; // 볼륨이 만들어질 수 있는지 체크
            for (int j = 0; j <= M; j++) {
                if (dt[i - 1][j]) {
                    flag = true;
                    if (j - volumes[i] >= 0) dt[i][j - volumes[i]] = true;
                    if (j + volumes[i] <= M) dt[i][j + volumes[i]] = true;
                }
            }
            
            if (!flag) break;
        }
        
        int result = -1;
        for (int j = M; j >= 0; j--) {
            if (dt[N][j]) {
                result = j;
                break;
            }
        }
        
        out.write(result + "");
        out.flush();
        out.close();
    }
}
