import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution1247
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input/1247.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[][] customers = new int[N][2];
            int[] work = { sc.nextInt(), sc.nextInt() };
            int[] home = { sc.nextInt(), sc.nextInt() };
            for(int i = 0; i < N; i++) {
                customers[i][0] = sc.nextInt();
                customers[i][1] = sc.nextInt();
            }

		}
		
		sc.close();
	}

    static int getDistance(int[] customer1, int[] customer2) {
        return Math.abs(customer1[0] - customer2[0]) + Math.abs(customer1[1] - customer2[1]);
    }

    static int getResult(int[] work, int[] home, int[][] customers) {
        int N = customers.length;
        int result = 99999;

        boolean[][] visited = new boolean[N][N];  // depth * visited
        boolean[] current = new boolean[N];  // visited index
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
            current[i] = false;
        }

        ArrayList<Integer> stack = new ArrayList<Integer>();

        int depth = -1;
        while(!visited[0][N-1] && stack.size() > 0) {
            depth++;
            int visitedIndex = -1;
            for(int i = 0; i < N; i++) {
                if(!visited[depth][i]) {
                    visitedIndex = i;
                    break;
                }
            }
            
            int currentIndex = -1;
            for(int i = 0; i < N; i++) {
                if(!current[i]) {
                    currentIndex = i;
                    break;
                }
            }

            if(depth < N-1 && visited[depth][visitedIndex]) // 

            // push 하면 continue 해야할 듯

            if(depth == N-1) {
                // 거리 계산하고 result와 비교 후 작은 것으로 할당
                int distance = 0;
                for(int i = 1; i < N; i++) {  // 고객 사이 거리 계산
                    int c1 = stack.get(i);
                    int c2 = stack.get(i-1);
                    distance += getDistance(customers[c1], customers[c2]);
                }
                distance += getDistance(work, customers[0]);  // 회사에서 첫 번째 고객 사이 거리 계산
                distance += getDistance(customers[N-1], home);  // 마지막 고객에서 집 사이 거리 계산
                result = Math.min(result, distance);
            }


            stack.remove(stack.size()-1);
        }
        return result;
    }
}