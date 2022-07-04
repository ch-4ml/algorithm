import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;

class Solution1974
{
	public static void main(String args[]) throws Exception
	{
        final int SIZE = 9;
        System.setIn(new FileInputStream("input/1974.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int result = 1;
            int[][] board = new int[SIZE][SIZE];

            rowCheck:
            for(int i = 0; i < SIZE; i++) {
                ArrayList<Number> row = new ArrayList<Number>();
                for(int j = 0; j < SIZE; j++) {
                    int current = sc.nextInt();
                    board[i][j] = current;
                    if(row.contains(current)) {
                        System.out.println(row);
                        System.out.println(current);
                        result = 0;
                        break rowCheck;
                    }
                    row.add(current);
                }
            }

            if(result == 1) {
                // 세로 검사
                colCheck:
                for(int i = 0; i < SIZE; i++) {
                    ArrayList<Number> col = new ArrayList<Number>();
                    for(int j = 0; j < SIZE; j++) {
                        int current = board[j][i];
                        if(col.contains(current)) {
                            System.out.println(col);
                            System.out.println(current);
                            result = 0;
                            break colCheck;
                        }
                        col.add(current);
                    }
                }
            }

            System.out.println(String.format("#%s %s", test_case, result));
		}
		
		sc.close();
	}
}