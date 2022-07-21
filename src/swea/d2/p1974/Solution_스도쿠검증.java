package swea.d2.p1974;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;

class Solution_스도쿠검증
{
	public static void main(String args[]) throws Exception
	{
        final int OUTER = 9;
        final int INNER = 3;
        System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int result = 1;
            int[][] board = new int[OUTER][OUTER];

            // Make board
            for(int i = 0; i < OUTER; i++) {
                for(int j = 0; j < OUTER; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            check:
            for(int i = 0; i < OUTER; i++) {
                ArrayList<Number> row = new ArrayList<Number>();
                ArrayList<Number> col = new ArrayList<Number>();
                for(int j = 0; j < OUTER; j++) {
                    // Check row
                    int r = board[i][j];
                    if(row.contains(r)) {
                        result = 0;
                        break check;
                    }
                    row.add(r);

                    // Check column
                    int c = board[j][i];
                    if(col.contains(c)) {
                        result = 0;
                        break check;
                    }
                    col.add(c);
                }
            }

            checkInner:
            for(int i = 0; i < INNER; i++) {
                for(int j = 0; j < INNER; j++) {
                    ArrayList<Number> rect = new ArrayList<Number>();
                    for(int k = i * INNER; k < i * INNER + INNER; k++) {
                        for(int l = j * INNER; l < j * INNER + INNER; l++) {
                            int r = board[k][l];
                            if(rect.contains(r)) {
                                result = 0;
                                break checkInner;
                            }
                            rect.add(r);
                        }
                    }
                }
            }

            System.out.println(String.format("#%s %s", test_case, result));
		}
		sc.close();
	}
}