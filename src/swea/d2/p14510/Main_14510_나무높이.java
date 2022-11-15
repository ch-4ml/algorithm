package swea.d2.p14510;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14510_나무높이 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(in.readLine());
            int[] trees = new int[N];
            List<Integer> leftHeights = new ArrayList<>();
            st = new StringTokenizer(in.readLine());
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                int tree = trees[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, tree);
            }
            
            int left = 0;
            for (int i = 0; i < N; i++) {
                int diff = max - trees[i];
                if (diff > 0) leftHeights.add(diff);
                left += diff;
            }
            
            leftHeights.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            
            int day = 0;
            int one = 0;
            int two = 0;
            calc:
            while (left > 0) {
                one = 0;
                two = 0;
                int size = leftHeights.size();
                int growth = ++day % 2 == 1 ? 1 : 2;
                for (int i = 0; i < size; i++) {
                    int current = leftHeights.get(i);
                    
                    if (current == growth) {
                        leftHeights.remove(i);
                        left -= growth;
                        continue calc;
                    }
                    
                    if (current == 1) one++;
                    else if(current == 2) two++;
                }
                
                if ((one == size && two == 0) || (one == 0 && two == size)) break;
                
                for (int i = 0; i < size; i++) {
                    int current = leftHeights.get(i);
                    if (current > growth) {
                        leftHeights.set(i, current - growth);
                        left -= growth;
                        break;
                    }
                }
            }
            
            if (left > 0) {
                day += leftHeights.size() * 2 - 1;
            }
            
            sb.append("#").append(t).append(" ").append(day).append("\n");
        }
        
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
