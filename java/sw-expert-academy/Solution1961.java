import java.util.Scanner;
import java.io.FileInputStream;

public class Solution1961 {
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
            String[][] r90 = new String[N][N];
            String[][] r180 = new String[N][N];
            String[][] r270 = new String[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    String num = sc.next();
                    board[i][j] = num; 
                    r90[j][N-i-1] = num;
                    r180[N-i-1][N-j-1] = num;
                    r270[N-j-1][i] = num;
                }
            }         

            System.out.println(String.format("#%s", test_case));
            for(int i = 0; i < N; i++) {
                System.out.println(String.format("%s %s %s", String.join("", r90[i]), String.join("", r180[i]), String.join("", r270[i])));
            }
		}
		
		sc.close();
	}
}
