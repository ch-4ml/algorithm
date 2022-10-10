import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int SIZE = 9;
    static boolean flag;
    static int[][] board;
    static boolean[][] usedInRow, usedInCol, usedInRect;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        board = new int[SIZE][SIZE]; // 기존 스도쿠 보드
        usedInRow = new boolean[SIZE][10]; // N번째 Row에서 M을 사용하고 있는지 저장하는 배열
        usedInCol = new boolean[SIZE][10]; // N번째 Col에서 M을 사용하고 있는지 저장하는 배열
        usedInRect = new boolean[SIZE][10]; // N번째 Rect에서 M을 사용하고 있는지 저장하는 배열

        for (int i = 0; i < SIZE; i++) {
            String row = in.readLine();
            
            for (int j = 0; j < SIZE; j++) {
                int num = board[i][j] = row.charAt(j) - '0';
                if (num > 0) {
                    usedInRow[i][num] = true;
                    usedInCol[j][num] = true;
                    usedInRect[getRect(i, j)][num] = true;
                }
            }
        }

        // 스도쿠 완성하기
        sudoku(0);

        // 출력
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    static void sudoku(int idx) {
        if (idx == SIZE * SIZE) {
            flag = true; // 종료 조건 설정 안해주면 계속 돌아서 초기 상태로 돌아온다...
            return;
        }

        int row = idx / SIZE;
        int col = idx % SIZE;
        int rect = getRect(row, col);
     
        if (board[row][col] > 0) {
            sudoku(idx + 1);
            return;
        } else {
            for (int num = 1; num <= SIZE; num++) {
                if (isAvailable(row, col, rect, num)) {
                    toggle(row, col, rect, num);
                    sudoku(idx + 1);
                    
                    if (flag) return;
                    toggle(row, col, rect, num);
                }
            }            
        }
    }

    static int getRect(int row, int col) {
        return row / 3 * 3 + col / 3;
    }
    
    static void toggle(int row, int col, int rect, int num) {
        usedInRow[row][num] = !usedInRow[row][num];
        usedInCol[col][num] = !usedInCol[col][num];
        usedInRect[rect][num] = !usedInRect[rect][num];
        board[row][col] = board[row][col] == 0 ? num : 0;
    }
    
    static boolean isAvailable(int row, int col, int rect, int num) {
        return !usedInRow[row][num] && !usedInCol[col][num] && !usedInRect[rect][num];
    }
}