import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(begin);

        boolean[] visited = new boolean[words.length];
        int beginIndex = indexOf(words, begin);
        if (beginIndex > -1) visited[beginIndex] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String word = queue.poll();
                if (word == null) break;
                for (int i = 0; i < words.length; i += 1) {
                    if (!visited[i] && compare(word, words[i]) == 1) {
                        if (words[i].equals(target)) return count + 1;
                        queue.offer(words[i]);
                        visited[i] = true;
                    }
                }
            }
            count += 1;
        }

        return 0;
    }

    public int indexOf(String[] words, String word) {
        for (int i = 0; i < words.length; i += 1) {
            if (words[i].equals(word)) return i;
        }
        return -1;
    }

    public int compare(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i += 1) {
            if (word1.charAt(i) != word2.charAt(i)) count += 1;
        }
        return count;
    }
}