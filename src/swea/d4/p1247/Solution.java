package swea.d4.p1247;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));
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

            int result = getResult(work, home, customers);
            System.out.println(String.format("#%s %s", test_case, result));
		}
		
		sc.close();
	}

    static int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
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
        int depth = 0;
        do {
            int currentIndex;
            boolean[] tmpCurrent = current.clone();
            // 선택한 index가 이미 현재 depth에서 방문한 index가 아닌 경우만 실행
            do {
                currentIndex = indexOf(tmpCurrent);
                if(currentIndex < 0) break;
                tmpCurrent[currentIndex] = true;
            } while(visited[depth][currentIndex]);
            
            // 아직 탐색하지 않은 index가 있을 때
            if(currentIndex > -1) {
                visited[depth][currentIndex] = true;
                current[currentIndex] = true;
                stack.add(currentIndex);
                depth++;
                continue;
            }

            if(stack.size() == N) {
                // 거리 계산하고 result와 비교 후 작은 것으로 할당
                int distance = 0;
                for(int i = 1; i < stack.size(); i++) {  // 고객 사이 거리 계산
                    int c1 = stack.get(i-1);
                    int c2 = stack.get(i);
                    distance += getDistance(customers[c1], customers[c2]);
                }
                
                distance += getDistance(work, customers[stack.get(0)]);  // 회사에서 첫 번째 고객 사이 거리 계산
                distance += getDistance(customers[stack.get(N-1)], home);  // 마지막 고객에서 집 사이 거리 계산
                result = Math.min(result, distance);
            }

            depth--;
            if(depth < N-1) {
                for(int i = 0; i < N; i++) {
                    visited[depth+1][i] = false;
                }
            }
            int lastIndex = stack.remove(stack.size()-1);
            current[lastIndex] = false;      
        } while(indexOf(visited[0]) > -1 || stack.size() > 0);
        return result;
    }

    static int indexOf(boolean[] arr) {
        int index = -1;
        for(int i = 0; i < arr.length; i++) {
            if(!arr[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}