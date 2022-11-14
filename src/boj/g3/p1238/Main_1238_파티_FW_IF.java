package boj.g3.p1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1238_파티_FW_IF {
    
    static int INF = 1_000_000_000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()); // 파티장소
        int[][] town = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j)
                    town[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            town[start][end] = T;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    int tmp = town[i][k] + town[k][j];
                    //삼항연산자 사용
                    town[i][j] = town[i][j] > tmp ? tmp : town[i][j];
                    //if문 사용
                    /*
                     if(town[i][j]>tmp){
                        town[i][j] = tmp;
                    }
                    */
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            answer = answer < (town[i][X] + town[X][i]) ? (town[i][X] + town[X][i]) : answer;
        }
        System.out.println(answer);
    }
}
