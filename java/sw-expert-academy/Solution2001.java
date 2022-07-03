import java.util.Scanner;
import java.io.FileInputStream;

class Solution2001
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input/2001.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int M = sc.nextInt();
            int reps = N - M + 1;

            int[][] board = new int[N][N];
            int[][] flies = new int[reps][reps];
            int result = -1;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            for(int i = 0; i < reps; i++) {
                for(int j = 0; j < reps; j++) {
                    int sum = 0;
                    for(int k = i; k < i + M; k++) {
                        for(int l = j; l < j + M; l++) {
                            sum += board[k][l];
                        }
                    }
                    flies[i][j] = sum;
                }
            }

            for(int i = 0; i < reps; i++) {
                for(int j = 0; j < reps; j++) {
                    result = result > flies[i][j] ? result : flies[i][j];
               }
            }

            System.out.println(String.format("#%s %s", test_case, result));
		}
		
		sc.close();
	}
}