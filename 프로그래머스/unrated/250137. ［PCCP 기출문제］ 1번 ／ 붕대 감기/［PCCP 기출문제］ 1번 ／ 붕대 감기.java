class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int bandStart = 0;
        for (int i = 0; i < attacks.length; i += 1) {
            // 회복
            int healTime = attacks[i][0] - bandStart - 1;
            int healAmount = healTime * bandage[1] + (int)(healTime / bandage[0]) * bandage[2];
            answer = Math.min(health, answer + healAmount);
            
            // 공격
            bandStart = attacks[i][0];
            answer -= attacks[i][1];
            
            if (answer <= 0) return -1;
        }
        
        return answer;
    }
}