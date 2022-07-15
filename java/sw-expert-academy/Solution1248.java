import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.io.FileInputStream;

class Solution1248 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input/1248.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= 1; test_case++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			ArrayList<Integer> sVertices = new ArrayList<Integer>();
			ArrayList<Integer> fVertices = new ArrayList<Integer>();

			for (int i = 0; i < E; i++) {
				sVertices.add(sc.nextInt());
				fVertices.add(sc.nextInt());
			}

			// 이진 트리 그리기
			ArrayList<Integer> binaryTree = new ArrayList<Integer>();
			ArrayList<Integer> queue = new ArrayList<Integer>();
			queue.add(1);
			while (queue.size() > 0) {
				int vertex = queue.remove(0);
				binaryTree.add(vertex);
				for (int i = 0; i < 2; i++) {
					int index = indexOf(sVertices, vertex);
					if (index > 0) {
						queue.add(fVertices.get(index));
						sVertices.remove(index);
						fVertices.remove(index);
					} else
						binaryTree.add(0);
				}
			}
		}

		sc.close();
	}

	static int indexOf(ArrayList<Integer> arr, int target) {
		int index = -1;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) == target) {
				index = i;
				break;
			}
		}
		return index;
	}
}