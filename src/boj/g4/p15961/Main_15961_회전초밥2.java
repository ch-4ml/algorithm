package boj.g4.p15961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961_회전초밥2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N + k - 1];
        int[] index = new int[d + 1];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        for (int i = N; i < sushi.length; i++) {
            sushi[i] = sushi[idx++];
        }

        int answer = 0;
        int tmp = 0;
        for (int i = 0; i < k; i++) {
            if (index[sushi[i]]++ == 0)
                tmp++;
        }

        if (index[c] == 0) {
            answer = Math.max(answer, tmp + 1);
        } else {
            answer = Math.max(answer, tmp);
        }

        for (int i = 1; i < sushi.length - k; i++) {

            index[sushi[i - 1]]--;

            if (index[sushi[i - 1]] == 0) {
                tmp--;
            }

            if (index[sushi[i + k - 1]] == 0) {
                tmp++;
            }
            index[sushi[i + k - 1]]++;
            if (index[c] == 0) {
                answer = Math.max(answer, tmp + 1);
            } else {
                answer = Math.max(answer, tmp);
            }
        }
        sb.append(answer);
        System.out.println(answer);
    }
}