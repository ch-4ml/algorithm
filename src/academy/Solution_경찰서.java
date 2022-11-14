package academy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_경찰서 {
 // 마을의 개수 V, 경찰서의 개수 P, 조합 경우의 수 c static 변수 생성
    static int[] city, police;
    static int V, P, L, min;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 표준 입력을 Reader로 처리
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // 표준 출력을 Writer로 처리
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        // 문자열을 만들 StringBuilder
        StringBuilder sb = new StringBuilder();
        // 문자열을 공백 기준으로 분리하기 위한 Tokenizer
        StringTokenizer st;
        
        // 테스트 케이스 수 입력
        int T = Integer.parseInt(in.readLine());
        // 테스트 케이스마다 반복
        for (int t = 1; t <= T; t++) {
            // 거리의 최소 합을 구할 변수를 초기화
            min = Integer.MAX_VALUE;
            // 마을의 수, 경찰서 수, 좌표의 범위를 입력으로 받음
            st = new StringTokenizer(in.readLine());
            // 공백 기준으로 분리 (마을의 수)
            V = Integer.parseInt(st.nextToken());
            // 마을의 좌표를 저장할 배열
            city = new int[V];
            // 공백 기준으로 분리 (경찰서 수)
            P = Integer.parseInt(st.nextToken());
            // 경찰서의 좌표를 저장할 배열
            police = new int[P];
            // 공백 기준으로 분리 (좌표의 범위)
            L = Integer.parseInt(st.nextToken());
            
            // 마을의 좌표를 입력 받음
            st = new StringTokenizer(in.readLine());
            // 각 마을의 좌표를 배열에 저장
            for (int i = 0; i < V; i++) {
                city[i] = Integer.parseInt(st.nextToken());
            }
            
            // V중 P개를 선택하는 조합
            comb(0, 0);
            // 테스트 케이스 별 문자열 만들기
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        
        // 만들어진 문자열을 출력
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    // 조합의 수를 구하는 함수
    private static void comb(int cnt, int start) {
        // 목표하는 개수만큼 뽑은 경우 조합이 완성됨 (기저 조건)
        if (cnt == P) {
            int sum = 0;
            // 모든 마을과 경찰서의 거리를 비교하기 위해 반복
            for (int i = 0; i < V; i++) {
                // 비교하면서 최소 거리를 기록할 변수를 초기화
                int d = Integer.MAX_VALUE;
                // 모든 경찰서와의 거리를 반복해서 비교하며 최솟값을 할당
                for (int j = 0; j < P; j++) {
                    d = Math.min(d, getDistance(city[i], police[j]));
                }
                // 구한 최솟값을 거리에 합산
                sum += d;
            }
            // 구한 거리의 합이 최소면 최신화
            min = Math.min(min, sum);
            // 함수 반환
            return; 
        }
        
        // 조합은 한 번 선택한 것을 다시 고려할 필요가 없기 때문에 start index부터 시작하며 숫자 선택
        // 뽑을 수 있는 모든 수에 대해서 반복 (경찰서는 마을에 지을 수 있음)
        for (int i = start; i < V; i++) {
            police[cnt] = city[i]; // 경찰서의 위치
            // 재귀적으로 조합 함수를 호출.
            // 현재 뽑은 개수(cnt)와 뽑기를 시작할 index(start)를 하나씩 증가시키며 재귀 호출
            comb(cnt + 1, i + 1);
        }
    }
    
    // 거리를 구하는 함수
    private static int getDistance(int a, int b) {
        return Math.min(Math.abs(a - b), L - Math.abs(a - b));
    }
}
