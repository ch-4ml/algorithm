class Solution {
    public int[] solution(int brown, int yellow) {
        // x * y = yellow
        // 2x + 2y + 4 = brown

        int r = (int) Math.ceil(Math.sqrt(yellow));
        System.out.println(r);

        for (int y = 1; y <= r; y += 1) {
            if (yellow % y == 0) {
                int x = yellow / y;
                if ((x + y + 2) * 2 == brown) return new int[]{x + 2, y + 2};
            }
        }

        return null;
    }
}