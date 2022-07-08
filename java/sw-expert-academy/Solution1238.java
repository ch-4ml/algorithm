import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.HashMap;
import java.io.FileInputStream;

class Solution1238 {
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input/1238.txt"));
		Scanner sc = new Scanner(System.in);
		int test_case = 0;

        while(sc.hasNext()) {
            test_case++;
            int N = sc.nextInt();
            int startId = sc.nextInt();
            boolean[] visited = new boolean[100]; // 1 ~ 100, index 0 => 1
            Arrays.fill(visited, false);
            Map<Integer, ArrayList<Integer>> nodes = new HashMap<Integer, ArrayList<Integer>>();

            for(int i = 0; i < N / 2; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                if(nodes.get(from) != null) nodes.get(from).add(to);
                else nodes.put(from, new ArrayList<Integer>(Arrays.asList(to)));
            }

            Set<Integer> keys = nodes.keySet();
            for(Integer key: keys) {
                Set<Integer> set = new HashSet<Integer>(nodes.get(key));
                nodes.put(key, new ArrayList<Integer>(set));
            }

            ArrayList<Integer> currentNodes = new ArrayList<Integer>();
            ArrayList<Integer> nextNodes = new ArrayList<Integer>();
            currentNodes.add(startId);
            visited[startId-1] = true;
            while(currentNodes.size() > 0) {
                for(int i = 0; i < currentNodes.size(); i++) {
                    nextNodes = new ArrayList<Integer>();
                    ArrayList<Integer> targets = nodes.get(currentNodes.get(i));
                    System.out.print(targets.toString());
                    for(Integer target: targets) {
                        if(!visited[target-1]) {
                            nextNodes.add(target);
                            visited[target-1] = true;
                        }
                    }
                    System.out.println(" / " + nextNodes.toString());
                }

                currentNodes = nextNodes;
            }

            int result = -1;
            for(int i = 0; i < nextNodes.size(); i++) {
                result = Math.max(nextNodes.get(i), result);
            }

            System.out.println(String.format("#%s %s", test_case, result));
        }
		
		sc.close();
	}
}