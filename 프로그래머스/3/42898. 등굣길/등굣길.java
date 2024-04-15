class Solution {
    final int DIVISOR = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        boolean[][] isPuddle = new boolean[m][n];
        int[][] dp = new int[m][n];

        for (int[] puddle : puddles) {
            isPuddle[puddle[0] - 1][puddle[1] - 1] = true;
        }

        for (int i = 0; i < m; i += 1) {
            if (isPuddle[i][0]) break;
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i += 1) {
            if (isPuddle[0][i]) break;
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i += 1) {
            for (int j = 1; j < n; j += 1) {
                if (!isPuddle[i][j]) dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % DIVISOR;
            }
        }

        return dp[m - 1][n - 1] % DIVISOR;
    }
}