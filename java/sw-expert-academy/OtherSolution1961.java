import java.util.Scanner;
import java.io.FileInputStream;

public class OtherSolution1961 {
    public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input/1961.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            String[][] board = new String[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    board[i][j] = sc.next(); 
                }
            }         

            System.out.println(String.format("#%s", test_case));
            for(int i = 0; i < N; i++) {
                System.out.println(String.format("%s %s %s", readRow(board, N, i, 90), readRow(board, N, i, 180), readRow(board, N, i, 270)));
            }
		}
		
		sc.close();
	}

    public static String readRow(String[][] board, int size, int row, int degree) {
        String result = "";
        switch(degree) {
            case 90:
                for(int i = 0; i < size; i++) {
                    result += board[size-i-1][row];
                }
                break;

            case 180:
                for(int i = 0; i < size; i++) {
                    result += board[size-row-1][size-i-1];
                }
                break;

            case 270:
                for(int i = 0; i < size; i++) {
                    result += board[i][size-row-1];
                }
                break;
        }
        return result;
    }
}
