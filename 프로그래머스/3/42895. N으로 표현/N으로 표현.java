import java.util.ArrayList;
import java.util.List;

class Solution {
    int MAX_VALUE = 32000;
    int MAX_REPS = 8;
    // Dynamic table: i를 구하기 위해 필요한 N의 개수의 최솟값
    int[] dp = new int[MAX_VALUE + 1];
    // 숫자 N i개로 만들 수 있는 숫자 리스트
    List<List<Integer>> numbers = new ArrayList<>();

    public int solution(int N, int number) {
        numbers.add(null);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= MAX_REPS; i += 1) {
            sb.append(N);
            int repeatedN = Integer.parseInt(sb.toString());
            numbers.add(new ArrayList<>());
            write(repeatedN, i);
        }

        for (int i = 2; i <= MAX_REPS; i += 1) {
            for (int j = 1; j < i; j += 1) {
                process(numbers.get(j), numbers.get(i - j), i);
                if (dp[number] > 0) return dp[number];
            }
        }

        return -1;
    }

    // @는 사칙연산, 숫자 하나 붙이기
    // 1개: 숫자 N 1개로 만든 숫자 리스트
    // 2개: 숫자 N 1개로 만든 숫자 리스트(A) ==> A@A == B ==> N + N, N - N, N * N, N / N, NN
    // 3개: 숫자 N 1개로 만든 숫자 리스트(A) @ 숫자 N 2개로 만든 숫자 리스트(B) ==> A@B, B@A == C
    // 4개: A@C, B@B, C@A
    // 5개: A@D, B@C, C@B, D@A

    // A@B => N + (N + N), N - (N + N), N * (N + N), N / (N + N)
    //        N + (N - N), N - (N - N), N * (N - N), N / (N - N)
    //        N + (N * N), N - (N * N), N * (N * N), N / (N * N)
    //        N + (N / N), N - (N / N), N * (N / N), N / (N / N)
    // B@A => (N + N) + N, (N + N) - N, (N + N) * N, (N + N) / N,
    //        (N - N) + N, (N - N) - N, (N - N) * N, (N - N) / N,
    //        (N * N) + N, (N * N) - N, (N * N) * N, (N * N) / N,
    //        (N / N) + N, (N / N) - N, (N / N) * N, (N / N) / N,
    public void process(List<Integer> list1, List<Integer> list2, int depth) {
        for (Integer l1 : list1) {
            for (Integer l2 : list2) {
                calculate(l1, l2, depth);
            }
        }

        if (list1.equals(list2)) return;

        for (Integer l2 : list2) {
            for (Integer l1 : list1) {
                calculate(l2, l1, depth);
            }
        }
    }

    public void calculate(int a, int b, int depth) {
        write(a + b, depth);
        write(a - b, depth);
        write(a * b, depth);
        if (b > 0) write(a / b, depth);
    }

    public void write(int result, int depth) {
        if (result > 0 && result <= MAX_VALUE && dp[result] == 0) {
            dp[result] = depth;
            numbers.get(depth).add(result);
        }
    }
}