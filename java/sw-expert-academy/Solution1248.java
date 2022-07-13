import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution1248
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input/1248.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int V = sc.nextInt();
			int E = sc.nextInt();
			int[] sVertices = new int[E];
			int[] fVertices = new int[E];
			for(int i = 0; i < E; i++) {
				sVertices[i] = sc.nextInt();
				fVertices[i] = sc.nextInt();			
			}
			
			// 이진 트리 그리기
			
			
		}
		
		sc.close();
	}
}