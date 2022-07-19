import java.util.Scanner;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            
            // Draw map
            for(int i = 0; i < N; i++) {
                String[] row = sc.next().split("");
                int[] rowInt = new int[N];
                for(int j = 0; j < N; j++) {
                    rowInt[j] = Integer.parseInt(row[j]);
                }
                map[i] = rowInt;
            }

            int[] dx = { -1, 0, 1, 0 };
            int[] dy = { 0, -1, 0, 1 };

            // 각 좌표에 도달하기 위한 최소 시간을 기록하는 변수
            int[][] counter = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    counter[i][j] = -1;
                }
            }

            counter[0][0] = 0;

            List<ArrayList<Integer>> queue = new ArrayList<>();
            queue.add(new ArrayList<Integer>(Arrays.asList(0, 0)));
            
            while(queue.size() > 0) {
                ArrayList<Integer> currentCoordinate = queue.remove(0);
                int x = currentCoordinate.get(0);
                int y = currentCoordinate.get(1);

                // 다음 좌표에 도달하기 위해 걸리는 시간
                int count = counter[y][x] + map[y][x];

                for(int i = 0; i < dx.length; i++) {
                    // x, y 좌표가 index range를 벗어나지 않도록 체크
                    if((x + dx[i] > -1) && (y + dy[i] > -1) && (x + dx[i] < N) && (y + dy[i] < N)) {                        

                        int nextCount = counter[y+dy[i]][x+dx[i]];
                        // 다음 좌표에 도달하기 위해 걸리는 시간이 -1인 경우(탐색하지 않은 경우)
                        // 또는 (현재 좌표에 도달하기 위한 최소 시간 + 현재 좌표에서 걸리는 시간) <= 다음 좌표에 도달하기 위해 걸리는 시간인 경우
                        if(nextCount < 0 || count < nextCount) {
                            ArrayList<Integer> nextCoordinate = new ArrayList<Integer>();
                            counter[y+dy[i]][x+dx[i]] = count;
                            nextCoordinate.add(x + dx[i]);
                            nextCoordinate.add(y + dy[i]);
                            queue.add(nextCoordinate);
                        }
                    }
                }
            } 

            System.out.println(String.format("#%s %s", test_case, counter[N-1][N-1]));
		}
		
		sc.close();
	}
}
