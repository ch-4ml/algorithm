package swea.d5.p1248_공통조상;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			sc.nextInt(); // int V
			int E = sc.nextInt();
			int vertex1 = sc.nextInt();
			int vertex2 = sc.nextInt();
			ArrayList<Integer> sVertexes = new ArrayList<Integer>();
			ArrayList<Integer> fVertexes = new ArrayList<Integer>();

			for (int i = 0; i < E; i++) {
				sVertexes.add(sc.nextInt());
				fVertexes.add(sc.nextInt());
			}

			// 이진 트리 정보 (key: node, value: binary tree를 배열로 표시했을 때의 index)
			Map<Integer, Integer> binaryTree = new HashMap<Integer, Integer>();
			ArrayList<Integer> queue = new ArrayList<Integer>();
			binaryTree.put(1, 0);
			queue.add(1);
			while (queue.size() > 0) {
				int vertex = queue.remove(0);
				int index = binaryTree.get(vertex);

				for (int i = 1; i < 3; i++) {
					int vertexIndex = indexOf(sVertexes, vertex);
					if(vertexIndex > -1) {
						int childVertex = fVertexes.remove(vertexIndex);
						binaryTree.put(childVertex, index * 2 + i);
						queue.add(childVertex);
						sVertexes.remove(vertexIndex);
					}
				}
			}

			// 공통 조상 구하기
			int index1 = binaryTree.get(vertex1);
			int index2 = binaryTree.get(vertex2);
			while(index1 != index2) {
				if(index1 > index2) {
					index1 = getParentIndex(index1);
				} else {
					index2 = getParentIndex(index2);
				}
			}
			int lowestCommonAncestor = getKeyByValue(binaryTree, index1);

			// 서브 트리 구하기
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			for(Entry<Integer, Integer> entry: binaryTree.entrySet()) {
				indexes.add(entry.getValue());
			}
			queue.add(binaryTree.get(lowestCommonAncestor));
			int subTreeSize = 0;
			while(queue.size() > 0) {
				int index = queue.remove(0);
				subTreeSize++;
				for(int i = 1; i < 3; i++) {
					int childIndex = index * 2 + i;
					if(indexOf(indexes, childIndex) > -1) {
						queue.add(childIndex);
					}
				}
			}
			
			System.out.println(String.format("#%s %s %s", test_case, lowestCommonAncestor, subTreeSize));
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

	static int getParentIndex(int index) {
		return index % 2 == 1 ? (index - 1) / 2 : (index - 2) / 2;
	}

	static int getKeyByValue(Map<Integer, Integer> map, int value) {
		for(Entry<Integer, Integer> entry: map.entrySet()) {
			if(entry.getValue().equals(value)) {
				return entry.getKey();
			}
		}
		return -1;
	}
}