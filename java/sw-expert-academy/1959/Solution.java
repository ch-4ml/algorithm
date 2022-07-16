import java.util.Scanner;
// import java.io.FileInputStream;

class Solution1959
{
	public static void main(String args[]) throws Exception
	{
		// System.setIn(new FileInputStream("input/1959.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] A = new int[N];
			int[] B = new int[M];

			int min = Math.min(N, M);

			for(int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}

			for(int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			
			int[] results = new int[Math.abs(N - M) + 1];
			for(int i = 0; i < results.length; i++) {
				int sum = 0;
				for(int j = 0; j < min; j++) {
					sum += N > M ? A[i + j] * B[j] : A[j] * B[i + j];
				}
				results[i] = sum;
			}		
			
			int answer = -9999;
			for(int i = 0; i < results.length; i++) {
				answer = answer > results[i] ? answer : results[i];
			}

			System.out.println(String.format("#%s %s", test_case, answer));
		}

		sc.close();
	}
}