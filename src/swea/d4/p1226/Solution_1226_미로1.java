package swea.d4.p1226;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution_1226_미로1
{
    final static int N = 16;

	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
        int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int result = 0;
            int t = sc.nextInt();
            int[][] board = new int[N][N];
            int[][] visited = new int[N][N];

            // Draw board
            for(int i = 0; i < N; i++) {
                String[] row = sc.next().split("");
                int[] boardRow = new int[N];
                int[] visitedRow = new int[N];
                for(int j = 0; j < N; j++) {
                    int r = Integer.parseInt(row[j]);
                    boardRow[j] = r;
                    visitedRow[j] = r == 1 ? 1 : 0;
                }
                board[i] = boardRow;
                visited[i] = visitedRow;
            }           

            int[] dx = { 1, 0, -1, 0 };
            int[] dy = { 0, 1, 0, -1 };

            List<ArrayList<Integer>> stack = new ArrayList<>();
            stack.add(new ArrayList<Integer>(Arrays.asList(1, 1)));

            DFS:
            while(stack.size() > 0) {
                ArrayList<Integer> coordinate = stack.get(stack.size() - 1);
                int x = coordinate.get(0);
                int y = coordinate.get(1);

                if(board[y][x] == 3) {
                    result = 1;
                    break;
                }

                visited[y][x] = 1;

                for(int i = 0; i < dx.length; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if(visited[newY][newX] < 1) {
                        stack.add(new ArrayList<Integer>(Arrays.asList(newX, newY)));
                        continue DFS;
                    }
                }
                
                stack.remove(stack.size() - 1);
            }

            System.out.println(String.format("#%s %s", t, result));
		}
		
		sc.close();
	}
}