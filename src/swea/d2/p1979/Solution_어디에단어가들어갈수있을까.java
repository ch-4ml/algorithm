package swea.d2.p1979;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution_어디에단어가들어갈수있을까
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
      int N = sc.nextInt();
      int K = sc.nextInt();

      int[][] board = new int[N][N];

			int result = 0;

      for(int i = 0; i < N; i++) {
				int count = 0;
				boolean flag = false;
        for(int j = 0; j < N; j++) {
          board[i][j] = sc.nextInt();

					// 가로 체크
					flag = board[i][j] > 0 ? true : false;
					if(flag) count += 1;
					else if(count == K) {
						result += 1;
						count = 0;
					} else count = 0; 
        }
				if(count == K) result += 1;
      }

			for(int i = 0; i < N; i++) {
				int count = 0;
				boolean flag = false;
				for(int j = 0; j < N; j++) {
					flag = board[j][i] > 0 ? true : false;
					if(flag) count += 1;
					else if(count == K) {
						result += 1;
						count = 0;
					} else count = 0;
				}

				if(count == K) result += 1;
			}

			System.out.println(String.format("#%s %s", test_case, result));
		}
		
		sc.close();
	}
}