import java.util.Scanner;
import java.io.FileInputStream;

class SimpleTemplate
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input/0000.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		

		}
		
		sc.close();
	}
}