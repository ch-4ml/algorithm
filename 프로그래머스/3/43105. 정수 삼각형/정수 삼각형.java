class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;

        // Dynamic table: 삼각형 모양으로 구성된 이차원 배열의 각 원소가 가질 수 있는 최댓값을 저장하는 테이블
        int[][] dp = new int[height][];
        dp[0] = triangle[0];

        for (int i = 1; i < height; i += 1) {
            int[] row = triangle[i];
            int[] dpRow = new int[i + 1];
            for (int j = 0; j < i + 1; j += 1) {
                int max = Integer.MIN_VALUE;

                // 왼쪽 검사
                if (j > 0) max = Math.max(max, dp[i - 1][j - 1]);

                // 오른쪽 검사
                if (j < i) max = Math.max(max, dp[i - 1][j]);

                dpRow[j] = row[j] + max;
            }
            dp[i] = dpRow;
        }

        int answer = 0;
        for (int i = 0; i < height; i += 1) {
            answer = Math.max(answer, dp[height - 1][i]);
        }

        return answer;
    }
}