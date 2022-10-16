package boj.g4.p14500;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {

    /*
        블록 하나를 놓을 수 있는 경우
        사각형 블록 -> 그대로 (1개)
        일자 블록 -> 회전 (2개)
        Z자 블록 -> 회전 (2개) * 대칭 (2개) = 4개
        T자 블록 -> 회전 (4개)
        L자 블록 -> 회전 (4개) * 대칭 (2개) = 8개

        회전: [R][C], [C][R], [-R][-C], [-C][-R]
        대칭: [R][-C], [-R][C]
        결과: [R][C], [C][R], [-R][-C], [-C][-R], [R][-C], [C][-R], [-R][C], [-C][R]
    */

    // 만약 시간초과나면 범위를 좀 보정해줘야 할 듯
    static int[][][][] blocks = {
        {   // 사각형 블록
            { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } }
        },  
        {   // 일자 블록
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } } 
        },
        {   // Z자 블록
            { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } },
            { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } },
            { { 0, 0 }, { 0, -1 }, { 1, -1 }, { 1, -2 } },
            { { 0, 0 }, { 1, 0 }, { 1, -1 }, { 2, -1 } }
        },
        {   // T자 블록
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, 1 } },
            { { 0, 0 }, { 0, -1 }, { 0, -2 }, { -1, -1 } },
            { { 0, 0 }, { -1, 0 }, { -2, 0 }, { -1, -1 } }
        },
        {   // L자 블록
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } },
            { { 0, 0 }, { 0, -1 }, { 0, -2 }, { -1, -2 } },
            { { 0, 0 }, { -1, 0 }, { -2, 0 }, { -2, -1 } },
            { { 0, 0 }, { 0, -1 }, { 0, -2 }, { 1, -2 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, -1 } },
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 2 } },
            { { 0, 0 }, { -1, 0 }, { -2, 0 }, { -2, 1 } }
        }
    };
    static int[][] board, blocksR, blocksC;
    static int[] blockDirections;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        for (int type = 0; type < 5; type++) {
            for (int direction = 0, size = blocks[type].length; direction < size; direction++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        int value = 0;
                        for (int d = 0; d < 4; d++) {
                            int nr = i + blocks[type][direction][d][0];
                            int nc = j + blocks[type][direction][d][1];
                            if (!check(nr, nc, type, direction)) break;
                            value += board[nr][nc];
                        }
                        max = Math.max(max, value);
                    }
                }
            }
        }

        out.write(max + "");
        out.flush();
        out.close();
    }

    static boolean check(int r, int c, int blockType, int blockDirection) {
        return r < 0 || c < 0 || r >= N || c >= M ? false : true;
    }
}