import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[][] routes) {
        int answer = routes.length;

        List<int[]> routeList = Arrays.asList(routes);
        routeList.sort((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int beforeExit = routeList.get(0)[1];
        for (int i = 1, size = routeList.size(); i < size; i += 1) {
            int[] current = routeList.get(i);
            
            if (beforeExit >= current[0]) answer -= 1;
            else beforeExit = current[1];
        }

        return answer;
    }

    public String printList(List<int[]> list) {
        StringBuilder sb = new StringBuilder();
        for (int[] l : list) {
            sb.append("[");
            sb.append(l[0]);
            sb.append(", ");
            sb.append(l[1]);
            sb.append("], ");
        }
        return sb.toString();
    }
}