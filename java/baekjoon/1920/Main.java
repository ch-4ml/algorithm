import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileInputStream;

class Main {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        ArrayList<Integer> A = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            A.add(sc.nextInt());
        }
        Collections.sort(A);
        
        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            System.out.println(Collections.binarySearch(A, sc.nextInt()) > -1 ? 1 : 0);
        }

        sc.close();
    }
}